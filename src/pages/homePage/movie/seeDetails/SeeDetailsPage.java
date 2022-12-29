package pages.homePage.movie.seeDetails;



import static pages.CommandEnum.LIKE;
import static pages.CommandEnum.PURCHASE;
import static pages.CommandEnum.RATE;
import static pages.CommandEnum.WATCH;
import static pages.CommandEnum.getCommand;
import static pages.PageEnum.HOMEPAGE;
import static pages.PageEnum.LOGOUT;
import static pages.PageEnum.MOVIES;
import static pages.PageEnum.SEE_DETAILS;
import static pages.PageEnum.UPGRADES;
import static pages.PageEnum.getPage;


import java.util.Arrays;
import java.util.List;
import input.ActionInput;
import input.Movie;
import pages.CommandEnum;
import pages.InterpretCommand;
import pages.PageEnum;
import pages.ChangePage;
import pages.Command;
import pages.Page;
import users.User;

public final class SeeDetailsPage extends Page {
    private final User user;
    private final Movie movie;
    private final List<PageEnum> pages =
        Arrays.asList(HOMEPAGE, LOGOUT, MOVIES, UPGRADES, SEE_DETAILS);
    private final List<CommandEnum> commands = Arrays.asList(PURCHASE, WATCH, LIKE, RATE);

    public SeeDetailsPage(final User user, final Movie movie) {
        super();
        this.user = user;
        this.movie = movie;
    }

    @Override
    public void changePage(final ActionInput action) {
        ChangePage changePage = new ChangePage(action, user);
        changePage.execute(getPage(pages, action.getPage()));
    }

    @Override
    public Command interpretCommand(final ActionInput action) {
        InterpretCommand interpreter = new InterpretCommand(action, user, movie);
        CommandEnum feature = getCommand(commands, action.getFeature());
        return interpreter.interpret(feature);
    }
}

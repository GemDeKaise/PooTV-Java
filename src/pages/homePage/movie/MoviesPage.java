package pages.homePage.movie;

import static pages.CommandEnum.FILTER;
import static pages.CommandEnum.SEARCH;
import static pages.CommandEnum.getCommand;
import static pages.PageEnum.HOMEPAGE;
import static pages.PageEnum.LOGOUT;
import static pages.PageEnum.MOVIES;
import static pages.PageEnum.SEE_DETAILS;
import static pages.PageEnum.getPage;

import java.util.Arrays;
import java.util.List;
import input.ActionInput;
import pages.ChangePage;
import pages.Command;
import pages.CommandEnum;
import pages.InterpretCommand;
import pages.Page;
import pages.PageEnum;
import users.User;

public final class MoviesPage extends Page {
    private final User user;
    private final List<PageEnum> pages = Arrays.asList(SEE_DETAILS, LOGOUT, HOMEPAGE, MOVIES);

    private final List<CommandEnum> commands = Arrays.asList(FILTER, SEARCH);

    public MoviesPage(final User user) {
        super();
        this.user = user;
    }
    @Override
    public void changePage(final ActionInput action) {
        ChangePage changePage = new ChangePage(action, user);
        changePage.execute(getPage(pages, action.getPage()));
    }

    @Override
    public Command interpretCommand(final ActionInput action) {
        InterpretCommand interpreter = new InterpretCommand(action, user);
        CommandEnum feature = getCommand(commands, action.getFeature());
        return interpreter.interpret(feature);
    }
}

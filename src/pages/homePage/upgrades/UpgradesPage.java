package pages.homePage.upgrades;

import static pages.CommandEnum.BUY_PREMIUM;
import static pages.CommandEnum.BUY_TOKENS;
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

/**
 * A page for upgrading the user's account and purchasing tokens.
 */
public class UpgradesPage extends Page {
    // list of pages that can be accessed from this page
    private final List<PageEnum> pages = Arrays.asList(HOMEPAGE, LOGOUT, SEE_DETAILS, MOVIES);
    // list of commands that can be executed on this page
    private final List<CommandEnum> commands = Arrays.asList(BUY_PREMIUM, BUY_TOKENS);
    // the user currently logged in
    private final User user;

    /**
     * Constructs a new upgrades page for the given user.
     *
     * @param user the user currently logged in
     */
    public UpgradesPage(final User user) {
        super();
        this.user = user;
    }

    /**
     * Changes the current page for the user.
     *
     * @param action the action input object containing the page to change to
     */
    @Override
    public void changePage(final ActionInput action) {
        ChangePage changePage = new ChangePage(action, user);
        changePage.execute(getPage(pages, action.getPage()));
    }

    /**
     * Interprets the given action input and returns a command to execute.
     *
     * @param action the action input to interpret
     * @return the command to execute
     */
    @Override
    public Command interpretCommand(final ActionInput action) {
        InterpretCommand interpreter = new InterpretCommand(action, user);
        CommandEnum feature = getCommand(commands, action.getFeature());
        return interpreter.interpret(feature);
    }
}

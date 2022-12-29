package pages.homePage;

import static pages.PageEnum.LOGOUT;
import static pages.PageEnum.MOVIES;
import static pages.PageEnum.UPGRADES;
import static pages.PageEnum.getPage;

import java.util.Arrays;
import java.util.List;
import input.ActionInput;
import pages.ChangePage;
import pages.Command;
import pages.Page;
import pages.PageEnum;
import users.User;
import utils.Output;

public class HomePage extends Page {
    private final User user;
    private final List<PageEnum> pages = Arrays.asList(LOGOUT, UPGRADES, MOVIES);

    public HomePage(final User user) {
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
        return Output::printError;
    }

}

package pages.homePageNeauthorizated;

import static pages.PageEnum.LOGIN;
import static pages.PageEnum.REGISTER;
import static pages.PageEnum.getPage;

import java.util.Arrays;
import java.util.List;
import input.ActionInput;
import pages.InvalidCommand;
import pages.PageEnum;
import pages.ChangePage;
import pages.Command;
import pages.Page;

/**
 * A page for the home page that is not authorized.
 */
public class HomePageN extends Page {
    // list of pages that can be accessed from this page
    private final List<PageEnum> pages = Arrays.asList(LOGIN, REGISTER);

    /**
     * Constructs a new home page for an unauthorized user.
     */
    public HomePageN() {
        super();
    }

    /**
     * Changes the current page for the user.
     *
     * @param action the action input object containing the page to change to
     */
    @Override
    public void changePage(final ActionInput action) {
        ChangePage changePage = new ChangePage(action);
        changePage.execute(getPage(pages, action.getPage()));
    }

    /**
     * Interprets the given action input and returns a command to execute.
     *
     * @param action the action input to interpret
     * @return the command to execute
     */
    public Command interpretCommand(final ActionInput action) {
        return new InvalidCommand();
    }
}

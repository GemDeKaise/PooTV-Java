package pages.homePageNeauthorizated.login;

import static utils.Output.printError;
import static utils.Output.printUser;

import input.Credentials;
import pages.Command;
import pages.homePage.HomePage;
import pages.homePageNeauthorizated.HomePageN;
import users.User;
import utils.DataBase;
import java.util.ArrayList;

/**
 * A command that logs in a user with the specified credentials.
 */
public class LogInCommand implements Command {
    // the credentials of the user to log in
    private final Credentials credentials;

    /**
     * Constructs a new login command with the given credentials.
     *
     * @param credentials the credentials of the user to log in
     */
    public LogInCommand(final Credentials credentials) {
        this.credentials = credentials;
    }

    /**
     * Logs in the user with the specified credentials.
     */
    @Override
    public void execute() {
        DataBase dataBase = DataBase.getInstance();
        ArrayList<User> users = dataBase.getUsers();

        for (User user : users) {
            Credentials userCredentials = user.getCredentials();
            if (userCredentials.getName().equals(credentials.getName())
                && userCredentials.getPassword().equals(credentials.getPassword())) {

                printUser(user);
                dataBase.setPage(new HomePage(user));

                return;
            }
        }

        printError();
        dataBase.setPage(new HomePageN());
    }
}

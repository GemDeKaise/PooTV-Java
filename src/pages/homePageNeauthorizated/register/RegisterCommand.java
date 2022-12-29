package pages.homePageNeauthorizated.register;


import static utils.Output.printUser;

import input.Credentials;
import pages.Command;
import pages.homePage.HomePage;
import pages.homePageNeauthorizated.HomePageN;
import users.User;
import users.UserFactory;
import utils.DataBase;

/**
 * A command that registers a new user with the specified credentials.
 */
public class RegisterCommand implements Command {
    // the credentials of the user to register
    private final Credentials credentials;

    /**
     * Constructs a new register command with the given credentials.
     *
     * @param credentials the credentials of the user to register
     */
    public RegisterCommand(final Credentials credentials) {
        this.credentials = credentials;
    }

    /**
     * Registers a new user with the specified credentials.
     */
    @Override
    public void execute() {
        DataBase database = DataBase.getInstance();

        for (User user : database.getUsers()) {
            if (user.getCredentials().getName().equals(credentials.getName())) {
                database.setPage(new HomePageN());
                return;
            }
        }
        User user = UserFactory.create(credentials, credentials.getAccountType());
        database.getUsers().add(user);

        printUser(user);

        database.setPage(new HomePage(user));
    }
}

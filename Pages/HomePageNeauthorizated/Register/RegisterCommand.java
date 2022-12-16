package Pages.HomePageNeauthorizated.Register;

import static fileio.Output.*;

import Input.Credentials;
import Pages.Command;
import Pages.HomePage.HomePage;
import Pages.HomePageNeauthorizated.HomePageN;
import Users.User;
import Users.UserFactory;
import fileio.DataBase;

public class RegisterCommand implements Command {
	private final Credentials credentials;

	public RegisterCommand(Credentials credentials) {
		this.credentials = credentials;
	}

	@Override
	public void execute() {
		DataBase database = DataBase.getInstance();

		for (User user : database.getUsers()) {
			if (user.getCredentials().getName().equals(credentials.getName())) {
				database.setPage(new HomePageN());
				return;
			}
		}
		User user = UserFactory.getUser(credentials);
		database.getUsers().add(user);

		database.getOutput().add(Print(user, null, null));

		database.setPage(new HomePage(user));
	}

}


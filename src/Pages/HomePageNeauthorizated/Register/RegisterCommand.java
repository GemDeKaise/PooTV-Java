package src.Pages.HomePageNeauthorizated.Register;

import static src.fileio.Output.*;

import src.Input.Credentials;
import src.Pages.Command;
import src.Pages.HomePage.HomePage;
import src.Pages.HomePageNeauthorizated.HomePageN;
import src.Users.User;
import src.Users.UserFactory;
import src.fileio.DataBase;

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
		User user = UserFactory.create(credentials, credentials.getAccountType());
		database.getUsers().add(user);

		database.getOutput().add(Print(user, null, null));

		database.setPage(new HomePage(user));
	}

}


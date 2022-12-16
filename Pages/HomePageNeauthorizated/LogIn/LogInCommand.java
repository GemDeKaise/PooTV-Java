package Pages.HomePageNeauthorizated.LogIn;

import static fileio.Output.Print;
import static fileio.Output.Print;

import Input.Credentials;
import Pages.Command;
import Pages.HomePage.HomePage;
import Pages.HomePageNeauthorizated.HomePageN;
import Users.User;
import fileio.DataBase;
import fileio.Output;
import java.util.ArrayList;

public class LogInCommand implements Command {
	private final Credentials credentials;

	public LogInCommand(Credentials credentials) {
		this.credentials = credentials;
	}

	@Override
	public void execute() {
		DataBase dataBase = DataBase.getInstance();
		ArrayList<User> users = dataBase.getUsers();

		for (User user : users) {
			Credentials userCredentials = user.getCredentials();
			if (userCredentials.getName().equals(credentials.getName())
					&& userCredentials.getPassword().equals(credentials.getPassword())) {

				dataBase.getOutput().add(Print(user, null, null));
				dataBase.setPage(new HomePage(user));

				return;
			}
		}

		dataBase.getOutput().add(Output.Print(null,"Error", null));
		dataBase.setPage(new HomePageN());
	}
}


package src.Pages.HomePageNeauthorizated.LogIn;

import static src.fileio.Output.Print;
import static src.fileio.Output.PrintError;
import static src.fileio.Output.PrintUser;

import src.Input.Credentials;
import src.Pages.Command;
import src.Pages.HomePage.HomePage;
import src.Pages.HomePageNeauthorizated.HomePageN;
import src.Users.User;
import src.fileio.DataBase;
import src.fileio.Output;
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

				PrintUser(user);
				dataBase.setPage(new HomePage(user));

				return;
			}
		}

		PrintError();
		dataBase.setPage(new HomePageN());
	}
}


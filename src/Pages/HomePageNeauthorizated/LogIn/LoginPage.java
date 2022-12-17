package src.Pages.HomePageNeauthorizated.LogIn;

import src.Input.ActionInput;
import src.Pages.Command;
import src.Pages.InvalidCommand;
import src.Pages.Page;

public class LoginPage extends Page {
	public LoginPage() {
		super();
	}

	public void changePage(ActionInput action) {
	}

	public Command interpretCommand(ActionInput action) {
		if (action.getFeature().equals("login")) {
			return new LogInCommand(action.getCredentials());
		}

		return new InvalidCommand();
	}

}

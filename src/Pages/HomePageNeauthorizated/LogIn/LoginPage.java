package src.Pages.HomePageNeauthorizated.LogIn;

import src.Input.ActionInput;
import src.Pages.Page;

public class LoginPage extends Page {
	public LoginPage() {
		super();
	}

	public void changePage(ActionInput action) {
	}

	public void interpretCommand(ActionInput action) {
		if (action.getFeature().equals("login")) {
			setCommand(new LogInCommand(action.getCredentials()));
		}
	}

}

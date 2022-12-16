package Pages.HomePageNeauthorizated.LogIn;

import Input.ActionInput;
import Pages.Page;

public class LoginPage extends Page {
	public LoginPage() {
		super();
		commands.add("login");
	}

	public void changePage(ActionInput action) {
	}

	public void interpretCommand(ActionInput action) {
		if (action.getFeature().equals("login")) {
			setCommand(new LogInCommand(action.getCredentials()));
		}
	}

}

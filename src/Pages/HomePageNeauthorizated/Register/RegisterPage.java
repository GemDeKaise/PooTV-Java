package src.Pages.HomePageNeauthorizated.Register;

import src.Input.ActionInput;
import src.Pages.Page;

public class RegisterPage extends Page {

	public RegisterPage() {
		super();
	}

	public void changePage(ActionInput action) {
	}

	public void interpretCommand(ActionInput action) {
		if (action.getFeature().equals("register")) {
			setCommand(new RegisterCommand(action.getCredentials()));
		}
	}
}
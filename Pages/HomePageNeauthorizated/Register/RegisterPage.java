package Pages.HomePageNeauthorizated.Register;

import Input.ActionInput;
import Pages.Page;

public class RegisterPage extends Page {

	public RegisterPage() {
		super();
		commands.add("register");
	}

	public void changePage(ActionInput action) {
	}

	public void interpretCommand(ActionInput action) {
		if (action.getFeature().equals("register")) {
			setCommand(new RegisterCommand(action.getCredentials()));
		}
	}
}
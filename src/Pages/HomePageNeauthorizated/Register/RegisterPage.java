package src.Pages.HomePageNeauthorizated.Register;

import src.Input.ActionInput;
import src.Pages.Command;
import src.Pages.Page;

public class RegisterPage extends Page {

	public RegisterPage() {
		super();
	}

	public void changePage(ActionInput action) {
	}

	public Command interpretCommand(ActionInput action) {
		if (action.getFeature().equals("register")) {
			return new RegisterCommand(action.getCredentials());
		}

		return new Command() {
			@Override
			public void execute() {
			}
		};
	}
}
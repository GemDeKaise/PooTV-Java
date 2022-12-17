package src.Pages.HomePageNeauthorizated.LogIn;

import static src.Pages.CommandEnum.BUY_PREMIUM;
import static src.Pages.CommandEnum.LOGIN;
import static src.Pages.CommandEnum.getCommand;

import java.util.Arrays;
import java.util.List;
import src.Input.ActionInput;
import src.Input.Credentials;
import src.Pages.Command;
import src.Pages.CommandEnum;
import src.Pages.InterpretCommand;
import src.Pages.InvalidCommand;
import src.Pages.Page;

public class LoginPage extends Page {
	private List<CommandEnum> commands = Arrays.asList(LOGIN);
	public LoginPage() {
		super();
	}

	public void changePage(ActionInput action) {
	}

	public Command interpretCommand(ActionInput action) {
		InterpretCommand interpreter = new InterpretCommand(action);
		CommandEnum feature = getCommand(commands, action.getFeature());
		return interpreter.interpret(feature);
	}

}

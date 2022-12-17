package src.Pages.HomePageNeauthorizated.Register;

import static src.Pages.CommandEnum.REGISTER;
import static src.Pages.CommandEnum.getCommand;

import java.util.Arrays;
import java.util.List;
import src.Input.ActionInput;
import src.Pages.Command;
import src.Pages.CommandEnum;
import src.Pages.InterpretCommand;
import src.Pages.Page;

public class RegisterPage extends Page {
	private List<CommandEnum> commands = Arrays.asList(REGISTER);

	public RegisterPage() {
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
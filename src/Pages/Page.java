package src.Pages;

import src.Input.ActionInput;
import java.util.ArrayList;

public abstract class Page {

	protected Command command;

	public Page() {
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public void executeCommand() {
		command.execute();
	}

	public abstract void changePage(ActionInput action);

	public abstract void interpretCommand(ActionInput action);
}

package Pages;

import Input.ActionInput;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.ArrayList;

public abstract class Page {
	public ArrayList<String> nextPages = new ArrayList<String>();
	public ArrayList<String> commands = new ArrayList<String>();
	protected Command command;

	public Page() {
		nextPages.clear();
		commands.clear();
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

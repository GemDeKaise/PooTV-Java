package src.Pages;

public class Feature {
	Command command;

	public Feature(Command command) {
		super();
		this.command = command;
	}

	public void execute() {
		command.execute();
	}
}

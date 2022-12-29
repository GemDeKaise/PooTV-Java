package pages;

import static utils.Output.printError;

/**
 * A command that represents an invalid input.
 */
public class InvalidCommand implements Command {

    /**
     * Constructs a new invalid command.
     */
    public InvalidCommand() {
    }

    /**
     * Executes the command.
     */
    @Override
    public void execute() {
        printError();
    }
}

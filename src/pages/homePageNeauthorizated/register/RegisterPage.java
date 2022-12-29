package pages.homePageNeauthorizated.register;

import static pages.CommandEnum.REGISTER;
import static pages.CommandEnum.getCommand;

import java.util.List;
import input.ActionInput;
import pages.Command;
import pages.CommandEnum;
import pages.InterpretCommand;
import pages.Page;

/**
 * A page for registering a new user.
 */
public class RegisterPage extends Page {
    // list of commands that can be executed on this page
    private final List<CommandEnum> commands = List.of(REGISTER);

    /**
     * Constructs a new register page.
     */
    public RegisterPage() {
        super();
    }

    /**
     * Changes the current page for the user.
     *
     * @param action the action input object containing the page to change to
     */
    public void changePage(final ActionInput action) {
    }

    /**
     * Interprets the given action input and returns a command to execute.
     *
     * @param action the action input to interpret
     * @return the command to execute
     */
    public Command interpretCommand(final ActionInput action) {
        InterpretCommand interpreter = new InterpretCommand(action);
        CommandEnum feature = getCommand(commands, action.getFeature());
        return interpreter.interpret(feature);
    }
}

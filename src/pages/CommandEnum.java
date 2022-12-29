package pages;

import java.util.List;

/**
 * Store the commands of the application.
 */
public enum CommandEnum {
    LOGIN("login"),
    REGISTER("register"),
    SEARCH("search"),
    FILTER("filter"),
    PURCHASE("purchase"),
    WATCH("watch"),
    LIKE("like"),
    RATE("rate"),
    BUY_PREMIUM("buy premium account"),
    BUY_TOKENS("buy tokens"),
    ERROR("Error");

    private final String value;

    CommandEnum(final String value) {
        this.value = value;
    }

    /**
     * Get the command enum from the given list of commands.
     * @param commands the list of commands
     * @param value the value of the command
     * @return the command enum
     */
    public static CommandEnum getCommand(final List<CommandEnum> commands, final String value) {
        for (CommandEnum command : commands) {
            if (command.value.equals(value)) {
                return command;
            }
        }
        return ERROR;
    }
}

package pages;

public final class Feature {
    private final Command command;

    /**
     * Creates a new feature with the specified command.
     * @param command the command to be executed
     */
    public Feature(final Command command) {
        super();
        this.command = command;
    }

    /**
     * Executes the command.
     */
    public void execute() {
        command.execute();
    }
}

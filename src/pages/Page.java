package pages;

import input.ActionInput;

public abstract class Page {

    public Page() {
    }

    /**

     Changes the current page in the application based on the specified action.
     @param action the action that triggered the page change
     */
    public abstract void changePage(ActionInput action);

    /**

     Interprets the specified action and returns the corresponding command.
     @param action the action to be interpreted
     @return the command corresponding to the specified action
     */
    public abstract Command interpretCommand(ActionInput action);
}

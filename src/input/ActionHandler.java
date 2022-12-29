package input;

import pages.Feature;
import pages.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import utils.DataBase;

public final class ActionHandler {

    /**
     * Interprets user input and executes the corresponding action.
     *
     * @param action The user input to interpret.
     * @throws JsonProcessingException If there is an error processing the JSON input.
     */
    public void interpretInput(final ActionInput action) throws JsonProcessingException {
        Page page = DataBase.getInstance().getPage();
        if (action.getType().equals("change page")) {
            page.changePage(action);
        } else {
            Feature feature = new Feature(page.interpretCommand(action));
            feature.execute();
        }
    }
}

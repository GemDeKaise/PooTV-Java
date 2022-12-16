package src.Input;

import src.Pages.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import src.fileio.DataBase;

public class ActionHandler {
	public void interpretInput(ActionInput action) throws JsonProcessingException {
		Page page = DataBase.getInstance().getPage();
		if (action.getType().equals("change page")) {
			page.changePage(action);
		} else {
			page.interpretCommand(action);
			page.executeCommand();
		}
	}
}

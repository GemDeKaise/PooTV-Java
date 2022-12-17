package src.Pages;

import src.Input.ActionInput;
import java.util.ArrayList;

public abstract class Page {

	public Page() {
	}

	public abstract void changePage(ActionInput action);

	public abstract Command interpretCommand(ActionInput action);
}

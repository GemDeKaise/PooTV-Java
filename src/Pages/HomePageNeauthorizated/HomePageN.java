package src.Pages.HomePageNeauthorizated;

import static src.Pages.PageEnum.LOGIN;
import static src.Pages.PageEnum.REGISTER;
import static src.Pages.PageEnum.getPage;

import java.util.Arrays;
import java.util.List;
import src.Input.ActionInput;
import src.Pages.InvalidCommand;
import src.Pages.PageEnum;
import src.Pages.ChangePage;
import src.Pages.Command;
import src.Pages.Page;

public class HomePageN extends Page {
	List<PageEnum> pages = Arrays.asList(LOGIN, REGISTER);
	public HomePageN() {
		super();
	}

	public void changePage(ActionInput action) {
		ChangePage changePage = new ChangePage(action);
		changePage.execute(getPage(pages, action.getPage()));
	}

	public Command interpretCommand(ActionInput action) {
		return new InvalidCommand();
	}

}

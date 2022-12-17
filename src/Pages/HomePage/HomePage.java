package src.Pages.HomePage;

import static src.fileio.Output.Print;
import static src.Pages.PageEnum.*;
import static src.fileio.Output.PrintError;

import java.util.Arrays;
import java.util.List;
import src.Input.ActionInput;
import src.Pages.PageEnum;
import src.Pages.ChangePage;
import src.Pages.Command;
import src.Pages.Page;
import src.Users.User;
import src.fileio.DataBase;

public class HomePage extends Page {
	protected User user;
	List<PageEnum> pages = Arrays.asList(LOGOUT, UPGRADES, MOVIES);

	public HomePage(User user) {
		super();
		this.user = user;
	}

	public void changePage(ActionInput action) {
		ChangePage changePage = new ChangePage(action, user);
		changePage.execute(getPage(pages, action.getPage()));
	}

	public Command interpretCommand(ActionInput action) {
		return new Command() {
			@Override
			public void execute() {
				PrintError();
			}
		};
	}
}

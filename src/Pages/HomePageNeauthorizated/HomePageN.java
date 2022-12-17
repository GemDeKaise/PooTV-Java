package src.Pages.HomePageNeauthorizated;

import static src.PageNames.LOGIN;
import static src.PageNames.REGISTER;
import static src.PageNames.getPage;

import java.util.Arrays;
import java.util.List;
import src.Input.ActionInput;
import src.PageNames;
import src.Pages.ChangePage;
import src.Pages.Command;
import src.Pages.HomePageNeauthorizated.LogIn.LoginPage;
import src.Pages.HomePageNeauthorizated.Register.RegisterPage;
import src.Pages.Page;
import src.fileio.DataBase;

public class HomePageN extends Page {
	List<PageNames> pages = Arrays.asList(LOGIN, REGISTER);
	public HomePageN() {
		super();
	}

	public void changePage(ActionInput action) {
		ChangePage changePage = new ChangePage(action);
		changePage.execute(getPage(pages, action.getPage()));
	}

	public Command interpretCommand(ActionInput action) {
		return new Command() {
			@Override
			public void execute() {

			}
		};
	}

}

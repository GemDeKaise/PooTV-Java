package src.Pages.HomePageNeauthorizated;

import src.Input.ActionInput;
import src.Pages.HomePageNeauthorizated.LogIn.LoginPage;
import src.Pages.HomePageNeauthorizated.Register.RegisterPage;
import src.Pages.Page;
import src.fileio.DataBase;

public class HomePageN extends Page {

	public HomePageN() {
		super();
	}

	public void changePage(ActionInput action) {
		if (action.getPage().equals("login")) {
			DataBase.getInstance().setPage(new LoginPage());
		} else if (action.getPage().equals("register")) {
			DataBase.getInstance().setPage(new RegisterPage());
		}
	}

	public void interpretCommand(ActionInput action) {
	}

}

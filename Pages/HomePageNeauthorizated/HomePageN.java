package Pages.HomePageNeauthorizated;

import Input.ActionInput;
import Pages.HomePageNeauthorizated.LogIn.LoginPage;
import Pages.HomePageNeauthorizated.Register.RegisterPage;
import Pages.Page;
import fileio.DataBase;

public class HomePageN extends Page {

	public HomePageN() {
		super();
		nextPages.add("login");
		nextPages.add("register");
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

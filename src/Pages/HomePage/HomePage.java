package src.Pages.HomePage;

import static src.fileio.Output.Print;
import static src.PageNames.*;

import java.util.Arrays;
import java.util.List;
import src.Input.ActionInput;
import src.Input.Movie;
import src.PageNames;
import src.Pages.ChangePage;
import src.Pages.Command;
import src.Pages.HomePage.Movie.MoviesPage;
import src.Pages.Page;
import src.Users.User;
import src.fileio.DataBase;
import java.util.ArrayList;

public class HomePage extends Page {
	protected User user;
	List<PageNames> pages = Arrays.asList(LOGOUT, UPGRADES, MOVIES);

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
				DataBase.getInstance().getOutput().add(Print(null, "Error", null));
			}
		};
	}
}

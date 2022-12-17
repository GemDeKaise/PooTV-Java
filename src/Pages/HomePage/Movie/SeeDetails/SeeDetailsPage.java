package src.Pages.HomePage.Movie.SeeDetails;

import static src.PageNames.*;
import static src.fileio.Output.Print;

import java.util.Arrays;
import java.util.List;
import src.Input.ActionInput;
import src.Input.Movie;
import src.PageNames;
import src.Pages.ChangePage;
import src.Pages.Command;
import src.Pages.Page;
import src.Users.User;
import src.fileio.DataBase;

public class SeeDetailsPage extends Page {
	User user;
	Movie movie;
	List<PageNames> pages = Arrays.asList(HOMEPAGE, LOGOUT, MOVIES, UPGRADES);

	public SeeDetailsPage(User user, Movie movie) {
		super();
		this.user = user;
		this.movie = movie;
	}

	@Override
	public void changePage(ActionInput action) {
		ChangePage changePage = new ChangePage(action, user);
		changePage.execute(getPage(pages, action.getPage()));
	}

	@Override
	public Command interpretCommand(ActionInput action) {
		DataBase db = DataBase.getInstance();
		return new Command() {
			@Override
			public void execute() {
				db.getOutput().add(Print(user, null, null));
			}
		};
	}
}

package src.Pages.HomePage.Movie;

import static src.PageNames.HOMEPAGE;
import static src.PageNames.LOGOUT;
import static src.PageNames.SEE_DETAILS;
import static src.PageNames.getPage;
import static src.fileio.Output.Print;

import java.util.Arrays;
import java.util.List;
import src.Input.ActionInput;
import src.PageNames;
import src.Pages.ChangePage;
import src.Pages.Command;
import src.Pages.InvalidCommand;
import src.Pages.Page;
import src.Users.User;
import src.fileio.DataBase;

public class MoviesPage extends Page {
	User user;

	List<PageNames> pages = Arrays.asList(SEE_DETAILS, LOGOUT, HOMEPAGE);

	public MoviesPage(User user) {
		super();
		this.user = user;
	}

	@Override
	public void changePage(ActionInput action) {
		ChangePage changePage = new ChangePage(action, user);
		changePage.execute(getPage(pages, action.getPage()));
	}

	@Override
	public Command interpretCommand(ActionInput action) {
		if (action.getFeature().equals("search"))
			return new SearchCommand(user, action.getStartsWith());
		else if (action.getFeature().equals("filter"))
			return new FilterCommand(user, action.getFilters());
		else
			return new InvalidCommand();
	}
}

package src.Pages.HomePage.Movie;

import static src.Pages.CommandEnum.FILTER;
import static src.Pages.CommandEnum.SEARCH;
import static src.Pages.CommandEnum.getCommand;
import static src.Pages.PageEnum.HOMEPAGE;
import static src.Pages.PageEnum.LOGOUT;
import static src.Pages.PageEnum.MOVIES;
import static src.Pages.PageEnum.SEE_DETAILS;
import static src.Pages.PageEnum.getPage;

import java.util.Arrays;
import java.util.List;
import src.Input.ActionInput;
import src.Pages.CommandEnum;
import src.Pages.InterpretCommand;
import src.Pages.PageEnum;
import src.Pages.ChangePage;
import src.Pages.Command;
import src.Pages.InvalidCommand;
import src.Pages.Page;
import src.Users.User;

public class MoviesPage extends Page {
	private User user;
	private List<PageEnum> pages = Arrays.asList(SEE_DETAILS, LOGOUT, HOMEPAGE, MOVIES);

	private List<CommandEnum> commands = Arrays.asList(FILTER, SEARCH);

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
		InterpretCommand interpreter = new InterpretCommand(action, user);
		CommandEnum feature = getCommand(commands, action.getFeature());
		return interpreter.interpret(feature);
	}
}

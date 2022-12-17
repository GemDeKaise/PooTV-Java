package src.Pages.HomePage.Movie.SeeDetails;

import static src.Pages.CommandEnum.*;
import static src.Pages.PageEnum.*;

import java.util.Arrays;
import java.util.List;
import src.Input.ActionInput;
import src.Input.Movie;
import src.Pages.CommandEnum;
import src.Pages.InterpretCommand;
import src.Pages.PageEnum;
import src.Pages.ChangePage;
import src.Pages.Command;
import src.Pages.Page;
import src.Users.User;

public class SeeDetailsPage extends Page {
	User user;
	Movie movie;
	List<PageEnum> pages = Arrays.asList(HOMEPAGE, LOGOUT, MOVIES, UPGRADES, SEE_DETAILS);
	List<CommandEnum> commands = Arrays.asList(PURCHASE, WATCH, LIKE, RATE);

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
		InterpretCommand interpreter = new InterpretCommand(action, user, movie);
		CommandEnum feature = getCommand(commands, action.getFeature());
		return interpreter.interpret(feature);
	}
}

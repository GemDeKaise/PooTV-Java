package src.Pages.HomePage.Movie.SeeDetails;

import static src.fileio.Output.Print;

import src.Input.ActionInput;
import src.Input.Movie;
import src.Pages.Command;
import src.Pages.Page;
import src.Users.User;
import src.fileio.DataBase;

public class SeeDetailsPage extends Page {
	User user;
	Movie movie;
	public SeeDetailsPage(User user, Movie movie) {
		super();
		this.user = user;
		this.movie = movie;
	}


	@Override
	public void changePage(ActionInput action) {

	}

	@Override
	public void interpretCommand(ActionInput action) {
		DataBase db = DataBase.getInstance();
		setCommand(new Command() {
			@Override
			public void execute() {
				db.getOutput().add(Print(user, null, null));
			}
		});
	}
}

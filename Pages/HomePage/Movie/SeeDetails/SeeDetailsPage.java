package Pages.HomePage.Movie.SeeDetails;

import static fileio.Output.Print;

import Input.ActionInput;
import Input.Movie;
import Pages.Command;
import Pages.Page;
import Users.User;
import fileio.DataBase;

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

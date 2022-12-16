package src.Pages.HomePage;

import static src.fileio.Output.Print;

import src.Input.ActionInput;
import src.Input.Movie;
import src.Pages.Command;
import src.Pages.HomePage.Movie.MoviePage;
import src.Pages.HomePageNeauthorizated.HomePageN;
import src.Pages.Page;
import src.Users.User;
import src.fileio.DataBase;
import java.util.ArrayList;

public class HomePage extends Page {
	protected User user;

	public HomePage(User user) {
		super();
		this.user = user;
	}

	public void changePage(ActionInput action) {
		DataBase db = DataBase.getInstance();
		if (action.getPage().equals("logout")) {
			db.setPage(new HomePageN());
		} else if (action.getPage().equals("movies")) {
			ChangePageToMovie(action);
		} else if (action.getPage().equals("upgrades")) {
//			DataBase.getInstance().setPage(new UpgradesPage(user));
		} else {
			db.getOutput().add(Print(null, "Error", null));
		}
	}

	public void interpretCommand(ActionInput action) {
		setCommand(new Command() {
			@Override
			public void execute() {
				DataBase.getInstance().getOutput().add(Print(null, "Error", null));
			}
		});
	}

	private void ChangePageToMovie(ActionInput action) {
		DataBase db = DataBase.getInstance();
		db.setPage(new MoviePage(user, action.getMovieName()));
	    db.setCurrentMovies(checkBan(db.getMovies()));
		db.getOutput().add(Print(user, null, db.getCurrentMovies()));
	}

	private ArrayList<Movie> checkBan(ArrayList<Movie> movies) {
		ArrayList<Movie> result = new ArrayList<Movie>();
		for (Movie movie : movies) {
			if (!movie.getCountriesBanned().contains(user.getCredentials().getCountry())) {
				result.add(movie);
			}
		}
		return result;
	}
}

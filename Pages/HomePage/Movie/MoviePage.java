package Pages.HomePage.Movie;

import static fileio.Output.Print;

import Input.ActionInput;
import Input.Movie;
import Pages.Command;
import Pages.HomePage.Movie.SeeDetails.SeeDetailsPage;
import Pages.Page;
import Users.User;
import fileio.DataBase;
import java.util.ArrayList;

public class MoviePage extends Page {
	User user;
	String MovieName;
	public MoviePage(User user, String MovieName) {
		super();
		this.user = user;
		this.MovieName = MovieName;
	}

	@Override
	public void changePage(ActionInput action) {
		DataBase databse = DataBase.getInstance();
		if (action.getPage().equals("see details")) {
			changePageToSeeDetails(action);
		} else if (action.getPage().equals("back")) {
			// DataBase.getInstance().setPage(new HomePage(user));
		} else {
			// DataBase.getInstance().getOutput().add(Print());
		}
	}

	@Override
	public void interpretCommand(ActionInput action) {
		if (action.getFeature().equals("search"))
			setCommand(new SearchCommand(user, action.getStartsWith()));
		else if (action.getFeature().equals("filter"))
			setCommand(new FilterCommand(user, action.getFilters()));
		else
			setCommand(new Command() {
			@Override
			public void execute(){
				DataBase.getInstance().getOutput().add(Print(user, null, null));
			}
		});
	}

	private void changePageToSeeDetails(ActionInput action) {
		DataBase db = DataBase.getInstance();
		for (Movie movie : db.getMovies()) {
			if (movie.getName().equals(action.getMovieName())) {
				db.setPage(new SeeDetailsPage(user, movie));
				ArrayList<Movie> movies = new ArrayList<>();
				movies.add(movie);
				db.getOutput().add(Print(user, null, movies));
				return;
			}
		}
		db.getOutput().add(Print(null, "Error", null));
	}

}

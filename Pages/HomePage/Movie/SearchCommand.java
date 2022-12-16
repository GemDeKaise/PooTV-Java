package Pages.HomePage.Movie;

import static fileio.Output.Print;

import Input.Movie;
import Pages.Command;
import Users.User;
import fileio.DataBase;
import java.util.ArrayList;

public class SearchCommand implements Command {
	User user;
	String startsWith;
	public SearchCommand(User user, String startsWith) {
		super();
		this.user = user;
		this.startsWith = startsWith;
	}

	@Override
	public void execute() {
		ArrayList<Movie> movies = DataBase.getInstance().getMovies();
		ArrayList<Movie> result = new ArrayList<Movie>();

		for (Movie movie : movies) {
			if (movie.getName().startsWith(startsWith)) {
				result.add(movie);
			}
		}
		DataBase.getInstance().setCurrentMovies(result);
		DataBase.getInstance().getOutput().add(Print(user, null, result));
	}
}

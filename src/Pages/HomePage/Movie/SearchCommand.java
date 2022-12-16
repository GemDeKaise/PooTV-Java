package src.Pages.HomePage.Movie;

import static src.fileio.Output.Print;

import src.Input.Movie;
import src.Pages.Command;
import src.Users.User;
import src.fileio.DataBase;
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

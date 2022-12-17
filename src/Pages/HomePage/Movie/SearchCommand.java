package src.Pages.HomePage.Movie;

import static src.Pages.PageEnum.MOVIES;
import static src.Pages.PageEnum.SEE_DETAILS;
import static src.fileio.Output.Print;

import src.Input.Movie;
import src.Pages.ChangePage;
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
		ArrayList<Movie> movies = DataBase.getInstance().getCurrentMovies();
		ArrayList<Movie> result = new ArrayList<>();

		for (Movie movie : movies) {
			if (movie.getName().startsWith(startsWith)) {
				result.add(movie);
			}
		}

		if (result.size() == 0) {
			DataBase.getInstance().getOutput().add(Print(user, null, null));
		} else {
			DataBase.getInstance().setCurrentMovies(result);
			DataBase.getInstance().getOutput().add(Print(user, null, result));
		}

		DataBase.getInstance().setPage(new MoviesPage(user));
	}
}

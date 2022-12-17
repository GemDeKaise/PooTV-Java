package src.Pages.HomePage.Movie;

import static src.Pages.PageEnum.MOVIES;
import static src.Pages.PageEnum.SEE_DETAILS;
import static src.fileio.Output.Print;
import static src.fileio.Output.PrintUser;

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
			PrintUser(user);
		} else {
			DataBase.getInstance().setCurrentMovies(result);
			Print(user, result);
		}

		DataBase.getInstance().setPage(new MoviesPage(user));
	}
}

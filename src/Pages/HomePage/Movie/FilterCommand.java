package src.Pages.HomePage.Movie;

import static src.Pages.ChangePage.checkBan;
import static src.fileio.Output.Print;
import static src.fileio.Output.PrintUser;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import src.Input.Filters;
import src.Input.Movie;
import src.Input.Sort;
import src.Pages.Command;
import src.Users.User;
import src.fileio.DataBase;

public class FilterCommand implements Command {
	User user;
	Filters filters;

	public FilterCommand(User user, Filters filters) {
		super();
		this.user = user;
		this.filters = filters;
	}

	@Override
	public void execute() {
		DataBase dataBase = DataBase.getInstance();
		ArrayList<Movie> movies;
		movies = checkBan(dataBase.getMovies(), user);


		if (filters.getContains() != null) {
			movies = filterMovies(movies);
		}

		if (filters.getSort() != null) {
			sortMovies(movies);
		}

		if (movies.size() != 0) {
			DataBase.getInstance().setCurrentMovies(movies);
			Print(user, movies);
			return;
		}
		DataBase.getInstance().setCurrentMovies(movies);
		PrintUser(user);
	}


	private ArrayList<Movie> filterMovies(ArrayList<Movie> movies) {
		ArrayList<Movie> filteredMovies = new ArrayList<>();
		ArrayList<String> actors = filters.getContains().getActors();
		ArrayList<String> genre = filters.getContains().getGenre();

		for (Movie movie : movies) {
			boolean hasActor;
			boolean hasGenre;

			hasActor = new HashSet<>(movie.getActors()).containsAll(actors);

			hasGenre = new HashSet<>(movie.getGenres()).containsAll(genre);

			if (hasActor && hasGenre) {
				filteredMovies.add(movie);
			}
		}
		return filteredMovies;
	}


	public void sortMovies(ArrayList<Movie> movies) {
		Sort sort = filters.getSort();
		if (sort != null) {
			if (sort.getRating() != null) {
				if (sort.getRating().equals("decreasing"))
					movies.sort((o1, o2) ->  Double.compare(o2.getRating(), o1.getRating()));
				else
					movies.sort(Comparator.comparingDouble(Movie::getRating));
			}
			if (sort.getDuration() != null) {
				// sort by duration
				if (sort.getDuration().equals("decreasing"))
					movies.sort((o1, o2) -> (o2.getDuration() - o1.getDuration()));
				else
					movies.sort(Comparator.comparingInt(Movie::getDuration));
			}
		}
	}

}

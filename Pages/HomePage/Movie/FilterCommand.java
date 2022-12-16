package Pages.HomePage.Movie;

import static fileio.Output.Print;
import static fileio.Utils.cloneMovies;

import Input.Contains;
import Input.Filters;
import Input.Movie;
import Input.Sort;
import Pages.Command;
import Users.User;
import fileio.DataBase;
import java.util.ArrayList;
import java.util.Comparator;

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
		ArrayList<Movie> movies;
		DataBase db = DataBase.getInstance();
		if (filters.getContains() != null)
			movies = filterMovies(db.getCurrentMovies(), filters.getContains());
		else
			movies = db.getCurrentMovies();

		if (filters.getSort() != null) {
			sortMovies(movies, filters.getSort());
		}

		DataBase.getInstance().setCurrentMovies(movies);
		DataBase.getInstance().getOutput().add(Print(user, null, movies));
	}


	private ArrayList<Movie> filterMovies(ArrayList<Movie> movies, Contains contains) {
		ArrayList<Movie> filteredMovies = new ArrayList<>();
		ArrayList<String> actors = contains.getActors();
		ArrayList<String> genres = contains.getGenres();

		for (Movie movie: movies) {
			if ((actors == null || actors.contains(movie.getActors())) &&
				(genres == null || genres.contains(movie.getGenres()))) {
				filteredMovies.add(movie);
			}
		}
		return filteredMovies;
	}

	private void sortMovies(ArrayList<Movie> movies, Sort sort) {
		if (sort.getDuration() != null)
			movies.sort(Comparator.comparingInt(Movie::getDuration));

		if (sort.getRating() != null)
			movies.sort(Comparator.comparingDouble(Movie::getRating));
	}


}

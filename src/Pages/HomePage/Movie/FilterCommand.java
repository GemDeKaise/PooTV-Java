package src.Pages.HomePage.Movie;

import static src.fileio.Output.Print;

import src.Input.Contains;
import src.Input.Filters;
import src.Input.Movie;
import src.Input.Sort;
import src.Pages.Command;
import src.Users.User;
import src.fileio.DataBase;
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
		DataBase dataBase = DataBase.getInstance();
		if (filters.getContains() != null)
			movies = filterMovies(dataBase.getCurrentMovies(), filters.getContains());
		else
			movies = dataBase.getCurrentMovies();

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
				if (actors != null) {
								for (String actor: actors) {
									if (movie.getActors().contains(actor)) {
										filteredMovies.add(movie);
										break;
									}
								}
							}
				if (genres != null) {
					for (String genre: genres) {
						if (movie.getGenres().contains(genre)) {
							filteredMovies.add(movie);
							break;
						}
					}
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

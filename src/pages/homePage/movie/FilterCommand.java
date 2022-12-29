package pages.homePage.movie;

import static pages.ChangePage.checkBan;
import static utils.Output.printSuccess;
import static utils.Output.printUser;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import input.Filters;
import input.Movie;
import input.Sort;
import pages.Command;
import users.User;
import utils.DataBase;

public final class FilterCommand implements Command {
    private final User user;
    private final Filters filters;

    public FilterCommand(final User user, final Filters filters) {
        super();
        this.user = user;
        this.filters = filters;
    }

    /**

     Filters and sorts a list of movies based on the specified filters
     and displays the resulting list of movies to the user.
     */
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
            printSuccess(user, movies);
            return;
        }
        DataBase.getInstance().setCurrentMovies(movies);
        printUser(user);
    }


    /**
     Filters a list of movies based on the specified filters.
     @param movies the list of movies to filter
     @return the filtered list of movies
     */
    private ArrayList<Movie> filterMovies(final ArrayList<Movie> movies) {
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


    /**
     Sorts a list of movies based on the specified filters.
     @param movies the list of movies to sort
     */
    public void sortMovies(final ArrayList<Movie> movies) {
        Sort sort = filters.getSort();
        if (sort != null) {
            if (sort.getRating() != null) {
                if (sort.getRating().equals("decreasing")) {
                    movies.sort((o1, o2) ->  Double.compare(o2.getRating(), o1.getRating()));
                } else {
                    movies.sort(Comparator.comparingDouble(Movie::getRating));
                }
            }
            if (sort.getDuration() != null) {
                if (sort.getDuration().equals("decreasing")) {
                    movies.sort((o1, o2) -> (o2.getDuration() - o1.getDuration()));
                } else {
                    movies.sort(Comparator.comparingInt(Movie::getDuration));
                }
            }
        }
    }
}

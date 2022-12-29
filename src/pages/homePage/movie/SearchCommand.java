package pages.homePage.movie;

import static utils.Output.printSuccess;
import static utils.Output.printUser;

import java.util.ArrayList;
import input.Movie;
import pages.Command;
import users.User;
import utils.DataBase;

public final class SearchCommand implements Command {
    private final User user;
    private final String startsWith;
    public SearchCommand(final User user, final String startsWith) {
        super();
        this.user = user;
        this.startsWith = startsWith;
    }

    /**
     * Searches for movies that start with the specified string and displays the
     * resulting list of movies to the user.
     */
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
            printUser(user);
        } else {
            DataBase.getInstance().setCurrentMovies(result);
            printSuccess(user, result);
        }

        DataBase.getInstance().setPage(new MoviesPage(user));
    }
}

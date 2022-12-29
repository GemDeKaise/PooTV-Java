package pages.homePage.movie.seeDetails;

import static utils.Output.printSuccess;
import static utils.Output.printError;

import java.util.ArrayList;
import java.util.Collections;
import input.Movie;
import pages.Command;
import users.User;

public final class RateMovieCommand extends WatchCommand implements Command {

    private final int rating;
    private static final int MAX_RATING = 5;
    public RateMovieCommand(final User user, final Movie movie, final int rating) {
        super(user, movie);
        this.rating = rating;
    }

    /**
     * Rates a movie that has been purchased and watched by the user.
     */
    @Override
    public void execute() {
        if (alreadyPurchased(movie)) {
            printError();
            return;
        }

        if (!alreadyWatched(movie)) {
            printError();
            return;
        }

        if (alreadyRated(movie)) {
            printError();
            return;
        }

        if (rating < 0 || rating > MAX_RATING) {
            printError();
            return;
        }

        user.getRatedMovies().add(movie);
        movie.setNumRatings(movie.getNumRatings() + 1);
        movie.setAdded(movie.getAdded() + rating);
        movie.setRating((double) movie.getAdded() / movie.getNumRatings());
        printSuccess(user, new ArrayList<>(Collections.singletonList(movie)));
    }

    /**

     Determines if the user has already rated the specified movie.
     @param movie the movie to check
     @return true if the user has already rated the movie, false otherwise
     */
    private boolean alreadyRated(final Movie movie) {
        return user.getRatedMovies().contains(movie);
    }
}

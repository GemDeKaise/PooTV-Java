package pages.homePage.movie.seeDetails;

import static utils.Output.printSuccess;
import static utils.Output.printError;

import java.util.ArrayList;
import java.util.Collections;
import input.Movie;
import pages.Command;
import users.User;

public final class LikeCommand extends WatchCommand implements Command {

    public LikeCommand(final User user, final Movie movie) {
        super(user, movie);
    }

    /**
     * Executes the rate movie command.
     * <p>
     * If the movie has not been purchased or watched by the user, or has already been rated,
     * or the rating is invalid (less than 0 or greater than 5), an error message is printed.
     * Otherwise, the movie is added to the user's rated movies list, and the
     * Movie's rating is updated.
     * A success message is then printed.
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

        if (alreadyLiked(movie)) {
            printError();
            return;
        }

        user.getLikedMovies().add(movie);
        movie.setNumLikes(movie.getNumLikes() + 1);
        printSuccess(user, new ArrayList<>(Collections.singletonList(movie)));
    }

    /**
     * Returns whether the given movie has already been liked by the user.
     *
     * @param movie The movie to check.
     * @return `true` if the movie has already been liked by the user, `false` otherwise.
     */
    private boolean alreadyLiked(final Movie movie) {
        return user.getLikedMovies().contains(movie);
    }

}

package pages.homePage.movie.seeDetails;

import static utils.Output.printSuccess;
import static utils.Output.printError;

import java.util.ArrayList;
import java.util.Collections;
import input.Movie;
import pages.Command;
import users.User;

public class WatchCommand extends PurchaseCommand implements Command {
    public WatchCommand(final User user, final Movie movie) {
        super(user, movie);
    }

    /**
     * Executes the watch command.
     * <p>
     * If the movie has already been purchased or watched by the user, an error message is printed.
     * Otherwise, the movie is added to the user's watched movies list and a
     * success message is printed.
     */
    @Override
    public void execute() {
        if (alreadyPurchased(movie)) {
            printError();
            return;
        }

        if (alreadyWatched(movie)) {
            printError();
            return;
        }

        user.getWatchedMovies().add(movie);
        printSuccess(user, new ArrayList<>(Collections.singletonList(movie)));
    }

    /**
     * Returns whether the given movie has already been watched by the user.
     *
     * @param movie The movie to check.
     * @return `true` if the movie has already been watched by the user, `false` otherwise.
     */
    protected boolean alreadyWatched(final Movie movie) {
        return user.getWatchedMovies().contains(movie);
    }
}


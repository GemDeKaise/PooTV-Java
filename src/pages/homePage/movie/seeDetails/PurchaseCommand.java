package pages.homePage.movie.seeDetails;

import input.Movie;
import pages.Command;
import users.User;

public class PurchaseCommand implements Command {
    protected User user;
    protected Movie movie;
    public PurchaseCommand(final User user, final Movie movie) {
        super();
        this.user = user;
        this.movie = movie;
    }

    /**
     * Executes the purchase command.
     * The user buys the movie.
     */
    @Override
    public void execute() {
        user.buyMovie(movie);
    }

    /**
     * Returns whether the given movie has already been purchased by the user.
     *
     * @param movie The movie to check.
     * @return `false` if the movie has already been purchased by the user, `true` otherwise.
     */
    public boolean alreadyPurchased(final Movie theMovie) {
        return !user.getPurchasedMovies().contains(theMovie);
    }
}

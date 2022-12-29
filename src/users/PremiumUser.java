package users;

import static utils.Output.printSuccess;

import java.util.ArrayList;
import java.util.Collections;
import input.Credentials;
import input.Movie;

public final class PremiumUser extends User {
    public PremiumUser(final Credentials credentials) {
        super(credentials);
        credentials.setAccountType("premium");
    }

    @Override
    public void buyMovie(final Movie movie) {
        if (alreadyPurchased(movie)) {
            printSuccess(this, new ArrayList<>(Collections.singletonList(movie)));
            return;
        }

        if (numFreePremiumMovies > 0) {
            numFreePremiumMovies--;
            purchasedMovies.add(movie);
            printSuccess(this, new ArrayList<>(Collections.singletonList(movie)));
            return;
        }

        if (tokensCount >= 2) {
            tokensCount -= 2;
            purchasedMovies.add(movie);
            printSuccess(this, new ArrayList<>(Collections.singletonList(movie)));
        }
    }
}

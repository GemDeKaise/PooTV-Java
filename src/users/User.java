package users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import input.NotificationInput;
import java.util.ArrayList;
import javax.management.Notification;
import lombok.Getter;
import lombok.Setter;
import input.Credentials;
import input.Movie;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class User {
    public static final int MAX_FREE_MOVIES = 15;

    protected Credentials credentials;

    protected Integer tokensCount = 0;
    protected int numFreePremiumMovies = MAX_FREE_MOVIES;

    protected ArrayList<Movie> purchasedMovies = new ArrayList<>();
    protected ArrayList<Movie> watchedMovies = new ArrayList<>();
    protected ArrayList<Movie> likedMovies = new ArrayList<>();
    protected ArrayList<Movie> ratedMovies = new ArrayList<>();
    protected ArrayList<NotificationInput> notifications = new ArrayList<>();

    public User() {
    }

    public User(final Credentials credentials) {
        this.credentials = credentials;
    }

    /**

     Purchases a movie for the user.
     @param movie the movie to be purchased
     */
    public void buyMovie(final Movie movie) {
    }

    /**

     Determines if the user has already purchased the specified movie.
     @param movie the movie to check
     @return true if the user has already purchased the movie, false otherwise
     */
    public boolean alreadyPurchased(final Movie movie) {
        return purchasedMovies.contains(movie);
    }
}


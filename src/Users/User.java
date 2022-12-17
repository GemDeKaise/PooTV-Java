package src.Users;
import static src.fileio.Output.PrintUserError;

import lombok.Getter;
import lombok.Setter;
import src.Input.Movie;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import src.Input.Credentials;
import java.util.ArrayList;
import src.fileio.DataBase;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class User {

	protected Credentials credentials;

	Integer tokensCount = 0;
	int numFreePremiumMovies = 15;

	ArrayList<Movie> purchasedMovies = new ArrayList<>();
	ArrayList<Movie> watchedMovies = new ArrayList<>();
	ArrayList<Movie> likedMovies = new ArrayList<>();
	ArrayList<Movie> ratedMovies = new ArrayList<>();

	public User() {
	}

	public User(Credentials credentials) {
		this.credentials = credentials;
	}

	public void buyMovie(Movie movie) {
	}

	public boolean alreadyPurchased(Movie movie) {
		if (!purchasedMovies.contains(movie))
			return false;

		return true;
	}
}


package src.Users;
import lombok.Getter;
import lombok.Setter;
import src.Input.Movie;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import src.Input.Credentials;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class User {

	protected Credentials credentials;

	int tokensCount = 0;
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

	public void buyMovie() {
	}
}


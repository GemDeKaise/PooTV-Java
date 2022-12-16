package Users;
import Input.Movie;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import Input.Credentials;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

	protected Credentials credentials;
	int tokensCount = 0;
	int numFreePremiumMovies = 15;
	ArrayList<Movie> purchasedMovies = new ArrayList<Movie>();
	ArrayList<Movie> watchedMovies = new ArrayList<Movie>();
	ArrayList<Movie> likedMovies = new ArrayList<Movie>();

	public int getTokensCount() {
		return tokensCount;
	}

	public void setTokensCount(int tokensCount) {
		this.tokensCount = tokensCount;
	}

	public int getNumFreePremiumMovies() {
		return numFreePremiumMovies;
	}

	public void setNumFreePremiumMovies(int numFreePremiumMovies) {
		this.numFreePremiumMovies = numFreePremiumMovies;
	}

	public ArrayList<Movie> getPurchasedMovies() {
		return purchasedMovies;
	}

	public void setPurchasedMovies(ArrayList<Movie> purchasedMovies) {
		this.purchasedMovies = purchasedMovies;
	}

	public ArrayList<Movie> getWatchedMovies() {
		return watchedMovies;
	}

	public void setWatchedMovies(ArrayList<Movie> watchedMovies) {
		this.watchedMovies = watchedMovies;
	}

	public ArrayList<Movie> getLikedMovies() {
		return likedMovies;
	}

	public void setLikedMovies(ArrayList<Movie> likedMovies) {
		this.likedMovies = likedMovies;
	}

	public ArrayList<Movie> getRatedMovies() {
		return ratedMovies;
	}

	public void setRatedMovies(ArrayList<Movie> ratedMovies) {
		this.ratedMovies = ratedMovies;
	}

	ArrayList<Movie> ratedMovies = new ArrayList<Movie>();

	public User() {
	}

	public User(Credentials credentials) {
		this.credentials = credentials;
	}
	public void buyMovie() {
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}
}


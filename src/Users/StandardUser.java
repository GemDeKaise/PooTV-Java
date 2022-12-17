package src.Users;

import static src.fileio.Output.Print;
import static src.fileio.Output.PrintError;
import static src.fileio.Output.PrintOutput;
import static src.fileio.Output.PrintUserError;

import java.util.ArrayList;
import java.util.Arrays;
import src.Input.Credentials;
import src.Input.Movie;

public class StandardUser extends User {
	public StandardUser(Credentials credentials) {
		super(credentials);
	}

	@Override
	public void buyMovie(Movie movie) {
		if (alreadyPurchased(movie)) {
			Print(this, new ArrayList<>(Arrays.asList(movie)));
			return;
		}

		if (tokensCount >= 2) {
			tokensCount -= 2;
			purchasedMovies.add(movie);
			Print(this, new ArrayList<>(Arrays.asList(movie)));
			return;
		}

	}
}
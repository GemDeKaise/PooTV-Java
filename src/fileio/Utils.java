package src.fileio;

import src.Input.Movie;
import java.util.ArrayList;

public class Utils {
	public static ArrayList<Movie> cloneMovies(ArrayList<Movie> movies) {
		ArrayList<Movie> result = new ArrayList<Movie>();
		for (Movie movie : movies) {
			result.add(movie);
		}
		return result;
	}

}

package fileio;

import Input.Movie;
import Users.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;

public class Output {
	private static final ObjectMapper mapper = new ObjectMapper();

	public static ObjectNode Print(User user, String error, ArrayList<Movie> currentMoviesList) {
		ObjectNode node = new ObjectNode(mapper.getNodeFactory());

		node.set("error", error == null ? null : mapper.valueToTree(error));
		node.set("currentMoviesList", currentMoviesList == null ?
				new ArrayNode(mapper.getNodeFactory()) : mapper.valueToTree(currentMoviesList));
		node.set("currentUser", user == null ? null : mapper.valueToTree(user));

		return node;
	}

	private static ArrayNode print1(ArrayList<Movie> movies) {
		ArrayNode arrayNode = new ArrayNode(mapper.getNodeFactory());
		for (Movie movie : movies) {
			ObjectNode node = new ObjectNode(mapper.getNodeFactory());
			node.put("name", movie.getName());
			node.put("year", movie.getYear());
			node.put("duration", movie.getDuration());
			node.put("genres", mapper.valueToTree(movie.getGenres()));
			node.put("actors",  mapper.valueToTree(movie.getActors()));
			node.put("countriesBanned", mapper.valueToTree(movie.getCountriesBanned()));
			node.put("rating", movie.getRating());
			node.put("numLikes", movie.getNumLikes());
			node.put("numRatings", movie.getNumRatings());
			arrayNode.add(node);
		}
		return arrayNode;
	}


}

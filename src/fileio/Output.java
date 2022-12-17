package src.fileio;

import src.Input.Movie;
import src.Users.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;

public class Output {
	private static final ObjectMapper mapper = new ObjectMapper();

	public static void PrintOutput(User user, String error, ArrayList<Movie> currentMoviesList) {
		ObjectNode node = new ObjectNode(mapper.getNodeFactory());

		node.set("error", error == null ? null : mapper.valueToTree(error));
		node.set("currentMoviesList", currentMoviesList == null ?
			new ArrayNode(mapper.getNodeFactory()) : mapper.valueToTree(currentMoviesList));
		node.set("currentUser", user == null ? null : mapper.valueToTree(user));

		DataBase.getInstance().getOutput().add(node);
	}
	public static void Print(User user, ArrayList<Movie> currentMoviesList) {
		PrintOutput(user, null, currentMoviesList);
	}

	public static void PrintError() {
		PrintOutput(null, "Error", null);
	}

	public static void PrintUserError(User user) {
		PrintOutput(user, "error", null);
	}

	public static void PrintUser(User user) {
		PrintOutput(user, null, null);
	}
}

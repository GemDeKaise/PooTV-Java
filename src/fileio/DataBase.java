package src.fileio;

import lombok.Getter;
import lombok.Setter;
import src.Input.Input;
import src.Pages.HomePageNeauthorizated.HomePageN;
import src.Pages.Page;
import src.Users.User;
import src.Input.ActionInput;
import src.Input.Movie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class DataBase {
	private ArrayList<User> users;
	private ArrayList<Movie> movies;
	private ArrayList<ActionInput> actions;

	private ArrayList<Movie> currentMovies;
	Page page;
	ArrayNode output;
	private static DataBase instance;
	private DataBase() {
		page = new HomePageN();
		currentMovies = new ArrayList<Movie>();
		output = new ObjectMapper().createArrayNode();
	}

	public static synchronized DataBase getInstance() {
		if (instance == null)
			instance = new DataBase();
		return instance;
	}

	public void destroy() {
		instance = null;
	}

	public void setUp(Input input) {
		users = input.getUsers();
		movies = input.getMovies();
		actions = input.getActions();
	}
}

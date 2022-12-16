package Input;

import Pages.HomePageNeauthorizated.HomePageN;
import Pages.Page;
import Users.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Input {
	private ArrayList<User> users;
	private ArrayList<Movie> movies;

	private ArrayList<ActionInput> actions;

	Page page = new HomePageN();

	ObjectMapper mapper = new ObjectMapper();
	ArrayNode output = mapper.createArrayNode();

	// Private constructor to prevent direct instantiation
	public Input() {
	}

	public ArrayNode getOutput() {
		return output;
	}

	public void setOutput(ArrayNode output) {
		this.output = output;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public ArrayList<Movie> getMovies() {
		return movies;
	}

	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
	}


	public ArrayList<ActionInput> getActions() {
		return actions;
	}

	public void setActions(ArrayList<ActionInput> actions) {
		this.actions = actions;
	}
}

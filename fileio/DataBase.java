package fileio;

import Pages.HomePageNeauthorizated.HomePageN;
import Pages.Page;
import Users.User;
import Input.ActionInput;
import Input.Movie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataBase {
	private static DataBase instance;
	private DataBase() {
		page = new HomePageN();
	}

	public static synchronized DataBase getInstance() {
		if (instance == null)
			instance = new DataBase();
		return instance;
	}

	public void destroy() {
		instance = null;
	}

	private ArrayList<User> users;
	private ArrayList<Movie> movies;
	private ArrayList<ActionInput> actions;

	private ArrayList<Movie> currentMovies = new ArrayList<Movie>();
	Page page = new HomePageN();
	ObjectMapper mapper = new ObjectMapper();
	ArrayNode output = mapper.createArrayNode();

	public ArrayList<Movie> getCurrentMovies() {
		return currentMovies;
	}

	public void setCurrentMovies(ArrayList<Movie> currentMovies) {
		this.currentMovies = currentMovies;
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

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public ObjectMapper getMapper() {
		return mapper;
	}

	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	public ArrayNode getOutput() {
		return output;
	}

	public void setOutput(ArrayNode output) {
		this.output = output;
	}
}

package src.Input;

import lombok.Getter;
import lombok.Setter;
import src.Pages.HomePageNeauthorizated.HomePageN;
import src.Pages.Page;
import src.Users.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class Input {

	private ArrayList<User> users;
	private ArrayList<Movie> movies;
	private ArrayList<ActionInput> actions;

	// Private constructor to prevent direct instantiation
	public Input() {
	}

}

package input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;
import users.User;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class Input {

    private ArrayList<User> users;
    private ArrayList<Movie> movies;
    private ArrayList<ActionInput> actions;

    public Input() {
    }

}

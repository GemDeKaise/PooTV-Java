package utils;

import lombok.Getter;
import lombok.Setter;
import input.Input;
import pages.homePageNeauthorizated.HomePageN;
import pages.Page;
import users.User;
import input.ActionInput;
import input.Movie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public final class DataBase {
    private ArrayList<User> users;
    private ArrayList<Movie> movies;
    private ArrayList<ActionInput> actions;

    private ArrayList<Movie> currentMovies;
    private Page page;
    private ArrayNode output;
    private static DataBase instance;
    private DataBase() {
        page = new HomePageN();
        currentMovies = new ArrayList<>();
        users = new ArrayList<>();
        output = new ObjectMapper().createArrayNode();
    }

    /**
     * Returns the single instance of the DataBase class.
     * <p>
     * This method uses the singleton design pattern to ensure that there is only
     * one instance of the DataBase class in the Java virtual machine. If no
     * instance has been created yet, this method will create a new instance and
     * assign it to the instance field. Otherwise, it will return the previously
     * created instance.
     *
     * @return the single instance of the DataBase class
     */
    public static synchronized DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    /**
     * Performs cleanup and destroys this object.
     * <p>
     * This method releases any resources held by this object and prepares it
     * for garbage collection. It should be called when the object is no longer
     * needed by the application.
     */
    public void destroy() {
        instance = null;
    }

    /**
     * Sets up the fields of this object with the given input.
     * <p>
     * This method sets the users, movies, and actions fields of this object
     * to the values contained in the given input object.
     *
     * @param input the input object containing the values to set
     */
    public void setUp(final Input input) {
        users = input.getUsers();
        movies = input.getMovies();
        actions = input.getActions();
    }
}

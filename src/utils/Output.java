package utils;

import input.Movie;
import users.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;

public final class Output {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private Output() {
    }

    /**
     * Prints out the given user, error message, and current movies list.
     * <p>
     * This method creates a new object node and sets its "error", "currentMoviesList",
     * and "currentUser" fields to the given error message, current movies list, and user,
     * respectively. It then adds the object node to the output field of the single instance
     * of the DataBase class.
     *
     * @param user the user to print out
     * @param error the error message to print out
     * @param currentMoviesList the current movies list to print out
     */
    private static void printOut(final User user, final String error,

        final ArrayList<Movie> currentMoviesList) {

        ObjectNode node = new ObjectNode(MAPPER.getNodeFactory());

        node.set("error", error == null ? null : MAPPER.valueToTree(error));

        node.set("currentMoviesList", currentMoviesList == null

            ? new ArrayNode(MAPPER.getNodeFactory())

            : MAPPER.valueToTree(currentMoviesList));

        node.set("currentUser", user == null ? null : MAPPER.valueToTree(user));

        DataBase.getInstance().getOutput().add(node);
    }

    /**
     * Prints out the given user and current movies list as a success message.
     * <p>
     * This method calls the printOut method with the given user, a null error message,
     * and the given current movies list.
     *
     * @param user the user to print out
     * @param currentMoviesList the current movies list to print out
     * @see #printOut(User, String, ArrayList)
     */
    public static void printSuccess(final User user,

        final ArrayList<Movie> currentMoviesList) {

        printOut(user, null, currentMoviesList);
    }

    /**
     * Prints out an error message.
     * <p>
     * This method calls the printOut method with a null user, the string "Error" as the
     * error message, and a null current movies list.
     *
     * @see #printOut(User, String, ArrayList)
     */
    public static void printError() {
        printOut(null, "Error", null);
    }

    /**
     * Prints out the given user.
     * <p>
     * This method calls the printOut method with the given user, a null error message,
     * and a null current movies list.
     *
     * @param user the user to print out
     * @see #printOut(User, String, ArrayList)
     */
    public static void printUser(final User user) {
        printOut(user, null, null);
    }
}

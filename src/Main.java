import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import input.ActionHandler;
import input.ActionInput;
import input.Input;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import users.User;
import users.UserFactory;
import utils.DataBase;

public class Main {

    /**
     * The main method of the application.
     */
    public static void main(final String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        DataBase.getInstance().destroy();

        Input input = objectMapper.readValue(new File(args[0]), Input.class);

        DataBase dataBase = DataBase.getInstance();
        dataBase.setUp(input);

        ArrayList<User> users = new ArrayList<>();
        for (User user : dataBase.getUsers()) {
            users.add(UserFactory.create(user.getCredentials(),
                user.getCredentials().getAccountType()));
        }
        dataBase.setUsers(users);

        for (ActionInput action : dataBase.getActions()) {
            ActionHandler actionHandler = new ActionHandler();
            actionHandler.interpretInput(action);
        }

        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(new File(args[1]), dataBase.getOutput());
        objectWriter.writeValue(new File(args[0].replace("/in", "/out")), dataBase.getOutput());

    }
}

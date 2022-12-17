import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.util.ArrayList;
import src.Input.Input;
import src.Input.ActionInput;
import src.Input.ActionHandler;
import src.Users.User;
import src.Users.UserFactory;
import src.fileio.DataBase;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        DataBase.getInstance().destroy();

        Input input = objectMapper.readValue(new File(args[0]), Input.class);
//        input = objectMapper.readValue(new File("/Users/anghelescuandrei/Desktop/POO/proba/POOTV/checker/resources/in/basic_10.json"), Input.class);

        DataBase dataBase = DataBase.getInstance();
        dataBase.setUp(input);

        ArrayList<User> users = new ArrayList<>();
        for (User user : dataBase.getUsers()) {
            users.add(UserFactory.create(user.getCredentials(), user.getCredentials().getAccountType()));
        }
        dataBase.setUsers(users);

        for (ActionInput action : dataBase.getActions()) {
            ActionHandler actionHandler = new ActionHandler();
            actionHandler.interpretInput(action);
        }

        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(new File(args[1]), dataBase.getOutput());

//        objectWriter.writeValue(new File(args[0].replace("/in", "/out")), dataBase.getOutput());
    }
}

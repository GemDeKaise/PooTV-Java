import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.util.ArrayList;
import java.util.Arrays;
import src.Input.Input;
import src.Input.ActionInput;
import src.Input.ActionHandler;
import src.Users.User;
import src.Users.UserFactory;
import src.fileio.DataBase;
import java.io.File;
import java.io.IOException;

public class myMain {
	public static void main(String[] args) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		DataBase.getInstance().destroy();

		// Use the existing instance of the src.Input class
		Input input;
		// Deserialize the JSON file and assign the result to the existing instance of the src.Input class
        input = objectMapper.readValue(new File("/Users/anghelescuandrei/Desktop/POO/proba/POOTV/checker/resources/in/basic_8.json"), Input.class);

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
        objectWriter.writeValue(new File("/Users/anghelescuandrei/Desktop/POO/proba/POOTV/checker/resources/out/basic_10.json"), dataBase.getOutput());

		dataBase.destroy();
	}
}
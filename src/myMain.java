import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import Input.Input;
import Input.ActionInput;
import Input.ActionHandler;
import fileio.DataBase;
import java.io.File;
import java.io.IOException;

public class myMain {
	public static void main(String[] args) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();

		// Use the existing instance of the Input class
		Input input;
		// Deserialize the JSON file and assign the result to the existing instance of the Input class
        input = objectMapper.readValue(new File("/Users/anghelescuandrei/Desktop/POO/proba/POOTV/checker/resources/in/basic_3.json"), Input.class);

		DataBase database = DataBase.getInstance();
		DataBase.getInstance().setUsers(input.getUsers());
		DataBase.getInstance().setMovies(input.getMovies());
		DataBase.getInstance().setActions(input.getActions());

		for (ActionInput action : database.getActions()) {
			ActionHandler actionHandler = new ActionHandler();
			actionHandler.interpretInput(action);
		}

		ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(new File("/Users/anghelescuandrei/Desktop/POO/proba/POOTV/out.json"), database.getOutput());

		database.destroy();
	}
}
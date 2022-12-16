import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import Input.Input;
import Input.ActionInput;
import Input.ActionHandler;
import fileio.DataBase;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        // Use the existing instance of the Input class
        Input input;
        input = objectMapper.readValue(new File(args[0]), Input.class);
//        input = objectMapper.readValue(new File("/Users/anghelescuandrei/Desktop/POO/proba/POOTV/checker/resources/in/basic_1.json"), Input.class);

        DataBase database = DataBase.getInstance();
        DataBase.getInstance().setUsers(input.getUsers());
        DataBase.getInstance().setMovies(input.getMovies());
        DataBase.getInstance().setActions(input.getActions());

        for (ActionInput action : database.getActions()) {
            ActionHandler actionHandler = new ActionHandler();
            actionHandler.interpretInput(action);
        }

//        DataBase dataBase2 = DataBase.getInstance();
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(new File(args[1]), database.getOutput());

        objectWriter.writeValue(new File(args[0].replace("/in", "/out")), database.getOutput());

        database.destroy();
//        objectWriter.writeValue(new File("/Users/anghelescuandrei/Desktop/POO/proba/POOTV/out.json"), database.getOutput());
    }
}

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import src.Input.Input;
import src.Input.ActionInput;
import src.Input.ActionHandler;
import src.fileio.DataBase;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Input input = objectMapper.readValue(new File(args[0]), Input.class);

        DataBase dataBase = DataBase.getInstance();
        dataBase.setUp(input);

        for (ActionInput action : dataBase.getActions()) {
            ActionHandler actionHandler = new ActionHandler();
            actionHandler.interpretInput(action);
        }

        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(new File(args[1]), dataBase.getOutput());

        objectWriter.writeValue(new File(args[0].replace("/in", "/out")), dataBase.getOutput());
        dataBase.destroy();
    }
}

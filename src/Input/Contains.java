package src.Input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Contains {

	ArrayList<String> actors = new ArrayList<>();
	ArrayList<String> genre = new ArrayList<>();

	public Contains() {
	}
}

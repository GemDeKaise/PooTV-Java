package src.Input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class Contains {

	ArrayList<String> actors;
	ArrayList<String> genres;

	public Contains() {
	}
}

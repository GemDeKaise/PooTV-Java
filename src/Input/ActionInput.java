package src.Input;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class ActionInput {

	String type;
	String feature;
	String page;
	String movieName;
	String startsWith;
	String count;

	Credentials credentials;

	Filters filters;

	public ActionInput() {
	}
}

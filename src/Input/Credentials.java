package src.Input;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class Credentials {

	private String name;
	private String password;
	private String accountType;
	private String country;
	private String balance;
}

package src.Input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class Filters {

	private Sort sort = new Sort();
	private Contains contains = new Contains();

	public Filters() {
	}

}

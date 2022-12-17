package src.Input;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class Movie {

	private String name;
	private int year;
	private int duration;

	private List<String> actors;
	private List<String> genres;
	private List<String> countriesBanned;

	private int numLikes;
	private double rating;
	@JsonIgnore
	private int added;

	private int numRatings;

	public Movie() {
	}
}

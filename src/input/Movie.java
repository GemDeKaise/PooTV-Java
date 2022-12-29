package input;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
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
    private int numRatings;

    @JsonIgnore
    private int added;


    public Movie() {
    }
}

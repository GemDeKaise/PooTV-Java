package input;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ActionInput {

    private String type;
    private String feature;
    private String page;
    private String movie;
    private String startsWith;
    private String count;

    private Credentials credentials;
    private Filters filters;

    private int rate;
    public ActionInput() {
    }
}

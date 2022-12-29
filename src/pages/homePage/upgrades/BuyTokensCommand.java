package pages.homePage.upgrades;

import pages.Command;
import users.User;

/**
 * A command that buys tokens for the user.
 */
public class BuyTokensCommand implements Command {
    // the user for whom to buy tokens
    private final User user;
    // the number of tokens to buy
    private final String count;

    /**
     * Constructs a new buy tokens command for the given user and number of tokens.
     *
     * @param user the user for whom to buy tokens
     * @param count the number of tokens to buy
     */
    public BuyTokensCommand(final User user, final String count) {
        super();
        this.user = user;
        this.count = count;
    }

    /**
     * Buys tokens for the user.
     */
    public void execute() {
        int tokens = Integer.parseInt(count);
        int balance = Integer.parseInt(user.getCredentials().getBalance());

        if (balance >= tokens) {
            user.setTokensCount(user.getTokensCount() + tokens);
            user.getCredentials().setBalance(String.valueOf(balance - tokens));
        }
    }
}

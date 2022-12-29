package pages.homePage.upgrades;

import pages.Command;
import users.User;
import users.UserFactory;
import utils.DataBase;

/**
 * A command that buys a premium subscription for the user.
 */
public class BuyPremiumCommand implements Command {
    // the cost of the premium subscription
    private static final int PREMIUM_COST = 10;
    // the user for whom to buy the premium subscription
    private User user;

    /**
     * Constructs a new buy premium command for the given user.
     *
     * @param user the user for whom to buy the premium subscription
     */
    public BuyPremiumCommand(final User user) {
        super();
        this.user = user;
    }

    /**
     * Buys a premium subscription for the user.
     */
    @Override
    public void execute() {
        if (user.getTokensCount() >= PREMIUM_COST) {
            DataBase.getInstance().getUsers().remove(user);
            int tokens = user.getTokensCount() - PREMIUM_COST;
            user = UserFactory.create(user.getCredentials(), "premium");
            user.setTokensCount(tokens);
            DataBase.getInstance().getUsers().add(user);
            DataBase.getInstance().setPage(new UpgradesPage(user));
        }
    }
}

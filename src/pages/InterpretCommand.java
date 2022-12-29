package pages;

import input.ActionInput;
import input.Movie;
import pages.homePage.movie.FilterCommand;
import pages.homePage.movie.SearchCommand;
import pages.homePage.movie.seeDetails.LikeCommand;
import pages.homePage.movie.seeDetails.PurchaseCommand;

import pages.homePage.movie.seeDetails.RateMovieCommand;
import pages.homePage.movie.seeDetails.WatchCommand;
import pages.homePage.upgrades.BuyPremiumCommand;
import pages.homePage.upgrades.BuyTokensCommand;
import pages.homePageNeauthorizated.login.LogInCommand;
import pages.homePageNeauthorizated.register.RegisterCommand;
import users.User;

public class InterpretCommand {

    private User user = null;
    private Movie movie = null;
    private final ActionInput action;
    public InterpretCommand(final ActionInput action) {
        this.action = action;
    }

    public InterpretCommand(final ActionInput action, final User user) {
        this.action = action;
        this.user = user;
    }

    public InterpretCommand(final ActionInput action, final User user, final Movie movie) {
        this.action = action;
        this.user = user;
        this.movie = movie;
    }

    /**
     * Interprets a command and returns the corresponding command object.
     *
     * @param feature The command to interpret.
     * @return The command object corresponding to the given command.
     */
    public Command interpret(final CommandEnum feature) {
        return switch (feature) {
            case LOGIN -> new LogInCommand(action.getCredentials());
            case REGISTER -> new RegisterCommand(action.getCredentials());
            case FILTER -> new FilterCommand(user, action.getFilters());
            case SEARCH -> new SearchCommand(user, action.getStartsWith());
            case BUY_PREMIUM -> new BuyPremiumCommand(user);
            case BUY_TOKENS -> new BuyTokensCommand(user, action.getCount());
            case PURCHASE -> new PurchaseCommand(user, movie);
            case WATCH -> new WatchCommand(user, movie);
            case LIKE -> new LikeCommand(user, movie);
            case RATE -> new RateMovieCommand(user, movie, action.getRate());
            case ERROR -> new InvalidCommand();
        };
    }
}


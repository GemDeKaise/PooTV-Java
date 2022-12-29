package pages;

import static utils.Output.printSuccess;
import static utils.Output.printError;

import java.util.ArrayList;
import java.util.Collections;
import input.ActionInput;
import input.Movie;
import pages.homePage.movie.MoviesPage;
import pages.homePage.movie.seeDetails.SeeDetailsPage;
import pages.homePage.upgrades.UpgradesPage;
import pages.homePageNeauthorizated.HomePageN;
import pages.homePageNeauthorizated.login.LoginPage;
import pages.homePageNeauthorizated.register.RegisterPage;
import users.User;
import utils.DataBase;

public final class ChangePage {
    private User user = null;

    private final ActionInput action;
    private final DataBase database = DataBase.getInstance();

    public ChangePage(final ActionInput action, final User user) {
        this.user = user;
        this.action = action;
    }

    public ChangePage(final ActionInput action) {
        this.action = action;
    }


    /**

     Changes the current page in the application to the page specified by the given page enum.
     @param page the page to change to
     */
    public void execute(final PageEnum page) {
        switch (page) {
            case LOGIN ->
                database.setPage(new LoginPage());
            case REGISTER ->
                database.setPage(new RegisterPage());
            case LOGOUT ->
                database.setPage(new HomePageN());
            case MOVIES ->
                setPageMovie();
            case UPGRADES ->
                database.setPage(new UpgradesPage(user));
            case SEE_DETAILS ->
                setPageToSeeDetails();
            default -> printError();
        }
    }

    /**

    Changes the current page to the movies page and sets
     the list of current movies based on the user's account status.
        */
    private void setPageMovie() {
        database.setPage(new MoviesPage(user));
        database.setCurrentMovies(checkBan(database.getMovies(), user));
        printSuccess(user, database.getCurrentMovies());
    }

    /**

     Returns a list of movies that the user is allowed to view based on their account status.
     @param movies the list of movies to check
     @param user the user whose account status to check
     @return a list of movies that the user is allowed to view
     */
    public static ArrayList<Movie> checkBan(final ArrayList<Movie> movies, final User user) {
        ArrayList<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            if (!movie.getCountriesBanned().contains(user.getCredentials().getCountry())) {
                result.add(movie);
            }
        }
        return result;
    }

    private void setPageToSeeDetails() {
        for (Movie movie : database.getCurrentMovies()) {
            if (movie.getName().equals(action.getMovie())) {
                database.setPage(new SeeDetailsPage(user, movie));
                ArrayList<Movie> movies = new ArrayList<>(Collections.singletonList(movie));
                database.setCurrentMovies(movies);
                printSuccess(user, movies);
                return;
            }
        }
        printError();
        database.setCurrentMovies(checkBan(database.getMovies(), user));
    }
}

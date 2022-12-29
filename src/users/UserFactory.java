package users;

import input.Credentials;

public final class UserFactory {

    private UserFactory() {

    }

    /**
     * Creates a new user with the given credentials and type.
     *
     * @param credentials The credentials of the user.
     * @param type The type of the user. Can be either "standard" or "premium".
     * @return A new user object with the given credentials and type.
     */
    public static User create(final Credentials credentials, final String type) {
        if (type.equals("premium")) {
            return new PremiumUser(credentials);
        } else {
            return new StandardUser(credentials);
        }
    }
}

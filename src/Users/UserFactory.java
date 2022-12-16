package src.Users;

import src.Input.Credentials;

public class UserFactory {
	public static User getUser(Credentials credentials) {
		if (credentials.getAccountType().equals("premium")) {
			return new PremiumUser(credentials);
		} else {
			return new StandardUser(credentials);
		}
	}
}

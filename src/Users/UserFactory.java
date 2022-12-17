package src.Users;

import src.Input.Credentials;

public class UserFactory {

	public UserFactory() {

	}

	public static User create(Credentials credentials, String type) {
		if (type.equals("premium")) {
			return new PremiumUser(credentials);
		} else {
			return new StandardUser(credentials);
		}
	}
}

package src.Users;

import src.Input.Credentials;

public class PremiumUser extends User{
	public PremiumUser(Credentials credentials) {
		super(credentials);
		credentials.setAccountType("premium");
	}

	@Override
	public void buyMovie() {

	}
}

import java.util.ArrayList;

class UserAccounts {

	String username;
	String password;

	UserAccounts(String username, String password) {
		this.username = username;
		this.password = password;
	}
}

public class Project4Q2 {

	static ArrayList<UserAccounts> users = new ArrayList<>();

	public static void registration(String username, String password) {

		for (UserAccounts user : users) {

			if (user.username.equals(username)) {
				System.out.println("Username already exists");
				return;
			}
		}

		users.add(new UserAccounts(username, password));
		System.out.println("Registration successful");
	}

	public static void main(String[] args) {

		registration("vikash", "1234");
		registration("karan", "5678");
		registration("nimesh", "1111");

		// Duplicate username
		registration("karan", "5678");

		System.out.println("Total users : " + users.size());
	}
}
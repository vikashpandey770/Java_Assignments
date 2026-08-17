import java.util.ArrayList;

class UserAccountss {

    private String username;
    private int password;
    UserAccountss(String username, int password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public int getPassword() {
        return password;
    }
}

public class ProjectQ3 {

    public static void login(ArrayList<UserAccountss> users,
                             String username, int password) {

        boolean found = false;

        for (UserAccountss user : users) {

            if (user.getUsername().equals(username)
                    && user.getPassword() == password) {

                System.out.println("Login successful");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Invalid credentials");
        }
    }

    public static void main(String[] args) {

        ArrayList<UserAccountss> UserAccount = new ArrayList<>();

        UserAccount.add(new UserAccountss("vikash", 23423));
        UserAccount.add(new UserAccountss("karan", 23424));
        UserAccount.add(new UserAccountss("jay", 424));

        login(UserAccount, "vika", 23423);
    }
}
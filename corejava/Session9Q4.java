import java.util.Scanner;

class AppUser {

    String username;

    AppUser(String username) {
        this.username = username;
        System.out.println("User name is: " + username);
    }
}

class VerifiedUser extends AppUser {

    VerifiedUser(String username) {
        super(username);
        System.out.println("Verified user class:" + username);
    }
}

class CelebrityUser extends VerifiedUser {

    CelebrityUser(String username) {
        super(username);
        System.out.println("Celebrity user:" + username);
    }
}

public class Session9Q4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a user name:");
        String username = sc.next();
        CelebrityUser cu = new CelebrityUser(username);
      
    }
}
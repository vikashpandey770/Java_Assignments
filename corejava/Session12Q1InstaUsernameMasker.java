
public class Session12Q1InstaUsernameMasker {

	public static void main(String[] args) {
String username="insta_rockstar123";

System.out.println(username);
System.out.println("-------Replace Version----");

String masked ="****"+username.substring(username.length()-13);
System.out.println(masked);

	}
}

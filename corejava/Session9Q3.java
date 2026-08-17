import java.util.Scanner;

class UserProfile{
	
	String user;
	int followers;
	String brandname;
	
	public void displayProfile(String u) {
		user=u;
		System.out.println("user's name: "+user);
	}
}

class InfluencerProfile extends UserProfile{
	public  void influProfile(String u,int f) {
		user=u;
		followers=f;
		
		
		System.out.println("user naem :"+user);
		System.out.println("followers :"+followers);
	}
	
}
class BrandProfile extends UserProfile{
	public void brandProfile(String b) {
		
		brandname=b;
		
		System.out.println("brand name is :"+brandname);
	}
	
}
public class Session9Q3 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a user name: ");
		String user=sc.next();
		
		System.out.println("enter a followers");
		int followers=sc.nextInt();
		
		System.out.println("enter a brand name: ");
		String brandname=sc.next();
		
		BrandProfile bf=new BrandProfile();
		UserProfile u=new UserProfile();
		InfluencerProfile ip=new InfluencerProfile();
		
	u.displayProfile(user);
	bf.brandProfile(brandname);
	ip.influProfile(user,followers);
		
		
		
	}
}

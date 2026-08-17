import java.util.Random;

public class Session4Q4 {

	public static void main(String[] args) {
		
		Random r=new Random();
		int RandomNumber;
		
		System.out.println("show the 7 day and 4 weeks data in instagram likes:");
	
		
		for(int i=1;i<=4;i++) {
			System.out.println("week "+i);	
		
		for(int j=1;j<=7;j++) {
			RandomNumber =r.nextInt(1000);
			System.out.print(j+"  day  ");
			System.out.println(j+RandomNumber);
			
		}
		}
	}
}

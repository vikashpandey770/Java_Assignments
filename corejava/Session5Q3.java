import java.util.Scanner;

public class Session5Q3 {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		int sum=0;
		double max=0;
		double min=0;
		Double[] amount=new Double[11];
		
		for(int i=1;i<amount.length;i++) {
			System.out.println(" enter your "+ i + " order amount:");
			amount[i]=sc.nextDouble();
			sum+=amount[i];

			if(amount[i]>max) {
				max=amount[i];
			}
			
			else if(amount[i]<min) {
				min=amount[i];
			}
			
			
		}
		
		System.out.println("Total spend of: " +sum);
		System.out.println("maximum order value is:"+max);
		System.out.println("minimum order value is:"+min);

		
	}
}

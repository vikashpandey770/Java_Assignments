
public class Session2Q2 {

	public static void main(String args[]) {
		double balance=1550;
		double per;
		
		if(balance>500) {

			per=balance-(balance*10 /100); 	
	System.out.println("10% less:"+balance);
			
	System.out.println("you can pay only:"+per);
		}
		else {
			System.out.println("not offer available");
		}
		
	}
}
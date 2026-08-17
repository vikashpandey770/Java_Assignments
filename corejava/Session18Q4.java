/*
 Multiple threads ka use karke Zomato ek time par multiple tasks perform kar sakta hai. Isse user ko har task ke complete hone ka wait nahi karna padta.
1. Order Update Thread
Ek thread order ki status update kar sakta hai.
Example: User ne pizza order kiya. Ek thread order status ko “Order Confirmed → Preparing → Out for Delivery” update karta rahega.
2. Notification Thread
Dusra thread user ko notifications send kar sakta hai.
Example: Restaurant ne order accept kiya, to notification thread turant “Your order has been accepted” ka notification bhej sakta hai.
3. Delivery Time Thread
Teesra thread delivery time calculate kar sakta hai.
Example: Delivery partner restaurant se nikalta hai, to thread traffic aur distance ke according “Your order will arrive in 25 minutes” calculate kar sakta hai.
 */
class Orderupdate extends Thread{
	
	public void run() {
		
		System.out.println("your order updating here.....");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class SendNotification extends Thread{
	
	public void run() {
		for(int i=0;i<3;i++) {
		System.out.println("your order notification parat........");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	}
}

class CalculateDeleveryTime extends Thread{
	
	public void run() {
		
		System.out.println("total time in 40 min in your order deleverd in your location...");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public class Session18Q4 {
public static void main(String[] args) {
	
	Orderupdate op=new Orderupdate();
	SendNotification sf=new SendNotification();
	CalculateDeleveryTime cdt=new CalculateDeleveryTime();
	
	Thread ts=new Thread(op);
	Thread tt=new Thread(sf);
	Thread ta=new Thread(cdt); 
	
	ts.start();
	tt.start();
	ta.start();
	
}
}



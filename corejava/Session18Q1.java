

class Notificationupdater implements Runnable{

	@Override
	public void run() {

for(int i=0;i<3;i++) {
	System.out.println("you have new notification");

	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
}
		
	}
	
	
}

public class Session18Q1 {

	public static void main(String[] args) {
		
		Notificationupdater nf=new Notificationupdater();
		
		Thread t=new Thread(nf);
		t.start();
	}
}

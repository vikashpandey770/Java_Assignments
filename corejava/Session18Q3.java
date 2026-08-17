class MisicCheck implements Runnable{

	@Override
	public void run() {
	
		while(true) {
			System.out.println("backgroud music check runing...	");
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
}
public class Session18Q3 {

	public static void main(String[] args) {
		
		MisicCheck mc=new MisicCheck();
	//	mc.run();
		
		Thread tt=new Thread(mc);
		tt.start();
	}
}

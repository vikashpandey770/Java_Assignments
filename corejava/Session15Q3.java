import java.io.FileOutputStream;
import java.io.IOException;

public class Session15Q3 {
	public void addToCart(FileOutputStream fos) throws IOException {
		String shop="Added:Redmi Note 12-Rs.12999";
	
		fos.write(shop.getBytes());
	}
	public static void main(String[] args) throws IOException {
	
		FileOutputStream fos=new FileOutputStream("cartlog.txt");
		
		
			Session15Q3 s=new Session15Q3();
			s.addToCart(fos);
		fos.flush();
		fos.close();
		System.out.println("create the program");
			
		
		
	}
}

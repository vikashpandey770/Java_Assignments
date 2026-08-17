import java.io.FileInputStream;
import java.io.IOException;


public class Session15Q4 {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("cartlog.txt");
		
		int i;
		int count=0;
		
		
		while((i=fis.read())!=-1) {
			
			System.out.print((char)i);
		
			if((char)i=='\n') {
				count++;
				
			}
		}
fis.close();		

System.out.println("\n total items "+count);
	}
}

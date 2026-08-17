import java.io.FileInputStream;
import java.io.IOException;

public class Session15Q2 {

	public static void main(String[] args) throws IOException  {
		
		FileInputStream fis=new FileInputStream("playlist.txt");
		int i;
		while((i=fis.read())!=-1){
			
			System.out.print((char)i);
		}
		
		fis.close();
	
}
	}

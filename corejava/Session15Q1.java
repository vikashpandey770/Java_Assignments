import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;


	
public class Session15Q1 {

	public static void main(String[] args) throws IOException {

		FileOutputStream fos=new FileOutputStream("playlist.txt");
			fos.write("music no 1\n".getBytes());
			fos.write("music no 2\n".getBytes());
			fos.write("music no 3\n".getBytes());
			fos.write("music no 4\n".getBytes());
			fos.write("music no 5\n".getBytes());
			
			fos.close();
			System.out.println("ok create data");
			
			
	}
}

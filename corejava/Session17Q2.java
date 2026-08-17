import java.util.LinkedHashMap;
import java.util.Map;

public class Session17Q2 {

	public static void main(String[] args) {
		
		LinkedHashMap<String ,String> songs=new LinkedHashMap<>();
		songs.put("kear", "arjit");
		songs.put("done","go");
		songs.put("noyes", "sf");
		
		System.out.println("-------- recent song ---------");
		
		for(Map.Entry<String, String> entry : songs.entrySet()) {
		System.out.println("Song : " + entry.getKey());
		System.out.println("Artist : " + entry.getValue());
	}
	}
}
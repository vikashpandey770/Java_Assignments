import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Session17Q4 {

	public static void main(String[] args) {

		HashMap<String,Integer> Instagram=new HashMap<>();
		
		Instagram.put("vsp",324);
		Instagram.put("vp",324);
		Instagram.put("abhi",324);
		Instagram.put("ramq3",34);
		Instagram.put("dsvf32",12334);
		Instagram.put("sfsfsfsfsf3",3240);

		System.out.println(Instagram);
		top3Users(Instagram);
	}
		
		
		public static void top3Users(HashMap<String, Integer> Instagram) {

			List<Map.Entry<String, Integer>> list =
					new ArrayList<>(Instagram.entrySet());

			Collections.sort(list, (a, b) ->
					b.getValue().compareTo(a.getValue()));

			System.out.println("------ Top 3 Instagram Users ------");

			int count = 0;

			for (Map.Entry<String, Integer> entry : list) {

				System.out.println("Username : " + entry.getKey());
				System.out.println("Followers : " + entry.getValue());
				System.out.println("----------------------");

				count++;

				if (count == 3) {
					break;
				}
				}	
	}
}

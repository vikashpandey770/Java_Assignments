
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Session16Q4
{

	public static void main(String[] args) {

		HashMap<String, Integer> hm = new HashMap<>();

		hm.put("vikash", 500);
		hm.put("vikrant", 1200);
		hm.put("vikram", 800);
		hm.put("vijay", 1200);
		hm.put("vish", 600);

		System.out.println(hm);

		Set set = hm.entrySet();
		Iterator itr = set.iterator();

		int maxFollowers = 0;

		while (itr.hasNext()) {

			Map.Entry<String, Integer> entry =
					(Map.Entry<String, Integer>) itr.next();

			System.out.println("Username : " + entry.getKey());
			System.out.println("Followers : " + entry.getValue());

			if (entry.getValue() > maxFollowers) {
				maxFollowers = entry.getValue();
			}
		}

		System.out.println("\nHighest Followers : " + maxFollowers);
		System.out.println("Username(s) with highest followers:");

		itr = set.iterator();

		while (itr.hasNext()) {

			Map.Entry<String, Integer> entry =
					(Map.Entry<String, Integer>) itr.next();

			if (entry.getValue() == maxFollowers) {
				System.out.println(entry.getKey());
			}
		}
	}
}
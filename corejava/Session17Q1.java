import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Session17Q1 {

	public static void main(String[] args) {
		
		HashMap<String , Double> hm=new HashMap<>();
	hm.put("Ab12123",1500.45);
	hm.put("go234234", 2500.42);
	hm.put("sdf1222",34.23);
	
	
	System.out.println(hm);
	
	
	System.out.println("-------------Iterator data-----------");
	Set set = hm.entrySet();

	Iterator itr = set.iterator();

	while (itr.hasNext()) {

		Map.Entry<String, Double> entry =
				(Map.Entry<String, Double>) itr.next();

		System.out.println("Order ID : " + entry.getKey());
		System.out.println("Amount   : " + entry.getValue());
		System.out.println("--------------------");
	}
}
}

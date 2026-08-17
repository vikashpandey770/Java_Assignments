import java.io.FileFilter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Session17Q3 {

	public static void main(String[] args) {

		HashMap<String ,Integer> product=new HashMap<>();
		product.put("java",1500);
		product.put("python",500);
		product.put("c++",1300);
		product.put("advance java",2000);
		product.put("script", 300);
		
		System.out.println(product);
		

		Set set = product.entrySet();

		Iterator itr = set.iterator();

		while (itr.hasNext()) {

			Map.Entry<String, Integer> entry =
					(Map.Entry<String, Integer>) itr.next();

			if (entry.getValue() > 1000) {

				System.out.println("Product Name : " + entry.getKey());
				System.out.println("Price : " + entry.getValue());
				System.out.println("----------------------");
			}	
	}
	}
}

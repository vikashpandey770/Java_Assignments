
public class Session12Q3 {

	public static void main(String[] args) {
		System.out.println("-------------this is a String Builder Program--------------");
		
		long startTime = System.currentTimeMillis();
		StringBuilder sbl=new StringBuilder("OR");
		
		for(int i=1;i<7;i++) {		
		sbl.append("ORD");
		}
		System.out.println("ORD"+(System.currentTimeMillis()-startTime));
		
		
		
		
	}
}


public class Session4Q1 {
public static void main(String[] args) {
	
	int step[]= {1500,1200,900,4500,700,5100,2300};
	int sum=0;
	
	/*for(int done:step) {
		
		System.out.println(done);
	}
	*/
	
	for(int i=0;i<step.length;i++) {
		System.out.println("day:"+ (i+1)+" step:"+step[i]);
	
		sum+=step[i];
		
	}
	System.out.println("Weekly total steps : "+sum);
}
}
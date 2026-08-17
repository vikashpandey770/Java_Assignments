
public class Session4Q2 {

	public static void main(String[] args) {
		
		double[] amount= {2500,1500,4800,4500,787,8050,6666,4785,985,4865,7854,7000};
double sum=0;
int i=0;
	while(i<amount.length) {
System.out.println(amount[i]);
		
		sum+=amount[i];
		i++;
	}
	
	System.out.println("total amount spent : "+sum);

	}
}

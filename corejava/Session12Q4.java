
public class Session12Q4 {

public static void main(String[] args) {
	String whatsp="this is a whatshapp message read only private persion not show any other . hello string program data and use the length methods";
	try {
	for(int i=0;i<whatsp.length();i++) {
		System.out.println(whatsp.charAt(i));
	}
	
	if(whatsp.length()>30) {
		System.out.println(whatsp.substring(0,30));
		System.out.println("this is a substring only 30 character print");
	}
	else {
		System.out.println(whatsp);
	}}
	catch(Exception e) {
		e.printStackTrace();
	}
	
}
}	


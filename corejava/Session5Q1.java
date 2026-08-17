import java.util.Scanner;

public class Session5Q1 {

    public static void main(String[] args) {

        Scanner sr=new Scanner(System.in);     
        String[] ad = new String[10];       
        for(int i=0;i<ad.length;i++) {
    	   System.out.print("Enter Product " +(i+1)+": ");    	    
    	   ad[i]=sr.next();
       }        
        System.out.println("show your all searches");
        for(String dr:ad) {
        	System.out.println(dr);
        }
    }
}
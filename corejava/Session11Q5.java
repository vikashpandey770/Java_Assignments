import java.util.Scanner;

abstract class Zomatostyle{
	String name;
	
	abstract void addorder(String name);
abstract void updateorder(String update);

abstract void deleteorder();
}

class createmethod extends Zomatostyle{
	@Override
	void addorder(String name) {
System.out.println("add  a any dish name: "+name);
	}
	@Override
	void updateorder(String update) {
String done=update;
update=name;
name=done;

System.out.println("update any your dish and order:"+done);	
	}
	@Override
	void deleteorder() {
System.out.println("delete tha all order here:");		
	}
}

public class Session11Q5 {
public static void main(String[] args) {
	
	createmethod cm=new createmethod();
	Scanner sc=new Scanner(System.in);
	System.out.println("enter a name: ");
	String name=sc.next();
	
	System.out.println("enter a update name: ");
	String update=sc.next();
	
	System.out.println("Enter a delete order name : ");
	String delete=sc.next();
	cm.addorder(name);
	cm.updateorder(update);
	cm.deleteorder();
	
}
}

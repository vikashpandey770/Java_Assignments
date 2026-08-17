import java.util.ArrayList;

class ProDuCt{
	String name;
	int price;
	
	ProDuCt(String n,int p){
		name=n;
		price=p;
	}
	
	public void totall(ArrayList<ProDuCt> cart) {
		double totals=0;
		
		for(ProDuCt p:cart) {
			totals=totals+p.price;
		}
		System.out.println("total cart value:"+totals);
	}
	
}

public class Session16Q3 {

	public static void main(String[] args) {
ArrayList <ProDuCt>  card=new ArrayList<>();

card.add(new ProDuCt("vikash",2132));
card.add(new ProDuCt("karan",132));
card.add(new ProDuCt("nimesh",22));

ProDuCt pd=new ProDuCt(null, 0);

pd.totall(card);
		
	}
}

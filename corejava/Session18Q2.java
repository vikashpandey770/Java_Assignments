class CashbackThread extends Thread {

    int balance =0;

    public void run() {

        for (int i=1;i<=6;i++) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance += 10;
            System.out.println("Add:Rs." + balance);
        }
        System.out.println("Final Balance:Rs." + balance);
    }
}
public class Session18Q2 {

    public static void main(String[] args) {
        CashbackThread ct = new CashbackThread();
        ct.start();
    }
}
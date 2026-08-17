class Wallets {

    public String maskWalletID(String walletID) {

        StringBuffer sb = new StringBuffer(walletID);

        for (int i=0;i<sb.length()-4;i++) {
            sb.setCharAt(i,'*');
        }
        return sb.toString();
    }
}
public class Session12Q5 {
    public static void main(String[] args) {
        Wallets w = new Wallets();
        String result = w.maskWalletID("WAL12345678");
        System.out.println(result);
    }
}
package PaymentGateway.BankingSystem;

import java.util.Random;

public class PaytmBanking implements Bankingsystem {
    private Random rand=new Random();

    public PaytmBanking(){};

    @Override
    public boolean ProcessPayment(double amount){
        System.out.println("paytm is processing payment of "+amount+" ");
        int r=rand.nextInt(100);
        return r>90; 
    }
    
}

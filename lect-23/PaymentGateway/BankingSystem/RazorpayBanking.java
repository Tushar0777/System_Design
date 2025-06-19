package PaymentGateway.BankingSystem;

import java.util.Random;

public class RazorpayBanking implements Bankingsystem {
    private Random rand=new Random();

    public RazorpayBanking(){};

    @Override
    public boolean ProcessPayment(double amount){
        System.out.println("razorpay is processing payment of "+amount+" ");
        int r=rand.nextInt(100);
        return r<80;
    }
    
}

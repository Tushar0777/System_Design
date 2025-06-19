package PaymentGateway;

import PaymentGateway.BankingSystem.Bankingsystem;

public abstract class PaymentGateway {
    private Bankingsystem bankingsystem;

    public PaymentGateway(){
        this.bankingsystem=null;
    }

    public boolean processPayment(PaymentRequest paymentrequest){
        if(!validate(paymentrequest)){
            System.out.println("PaymentGateway] Validation failed for " + paymentrequest.sender );
            return false;
        }
          if (!initiate(paymentrequest)) {
            System.out.println("[PaymentGateway] Initiation failed for " + paymentrequest.sender + ".");
            return false;
        }
        if (!confirm(paymentrequest)) {
            System.out.println("[PaymentGateway] Confirmation failed for " + paymentrequest.sender + ".");
            return false;
        }
        return true;

    }
    protected abstract boolean validate(PaymentRequest paymentrequest);
    protected abstract boolean initiate(PaymentRequest paymentrequest);
    protected abstract boolean confirm(PaymentRequest paymentrequest);
    
}

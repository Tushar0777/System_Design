package PaymentGateway;

public class PaymentRequest{
    String sender;
    String reciever;
    double amount;
    String currency;

    public PaymentRequest(String sender,String reciever,double amount,String currency){
        this.sender=sender;
        this.reciever=reciever;
        this.amount=amount;
        this.currency=currency;
        
    }
}
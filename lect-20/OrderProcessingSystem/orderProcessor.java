package OrderProcessingSystem;
public abstract class orderProcessor{

    public final void processorder(){
        validateorder();
        processPayment();
        dispatchOrder();
        sendNotification();
    }
    protected abstract void validateorder();
    protected abstract void processPayment();
    protected abstract void dispatchOrder();
    protected void sendNotification(){
        System.err.println("sending notification of completion");
    };

};


class amazonOrder extends orderProcessor{
    
    protected void validateorder(){
        System.out.println("validated by amazon");

    }
    protected void processPayment(){
        System.out.println("payment confirmed");

    }
    protected void dispatchOrder(){
        System.out.println("order dispatched");

    }
    protected void sendNotification(){
        System.out.println("sending notification from amazon");
    }
};
 
class zomatoOrder extends orderProcessor{
        protected void validateorder(){
        System.out.println("validated by zomato");

    }
    protected void processPayment(){
        System.out.println("payment confirmed");

    }
    protected void dispatchOrder(){
        System.out.println("order dispatched");

    }
    protected void sendNotification(){
        System.out.println("sending notification from zomato");
    }
};
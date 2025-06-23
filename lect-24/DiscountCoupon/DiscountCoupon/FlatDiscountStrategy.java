package DiscountCoupon;

public class FlatDiscountStrategy implements DiscountStrategy {
    private double amount;


    public FlatDiscountStrategy(double amount){
        this.amount=amount;
    }

    @Override
    public double calculate(double baseAmt){
        return Math.min(baseAmt,amount);
    }
    
}

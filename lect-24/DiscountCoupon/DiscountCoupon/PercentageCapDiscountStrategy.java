package DiscountCoupon;

public class PercentageCapDiscountStrategy implements DiscountStrategy {
    private Double percentage;
    private double cap;

    public PercentageCapDiscountStrategy(double percentage,double cap){
        this.percentage=percentage;
        this.cap=cap;
    }

    @Override
    public double calculate(double baseAmt) {
        double disc=(percentage/100)*baseAmt;

        return disc>cap?cap:disc;
       
    }
    
}

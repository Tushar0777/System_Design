package DiscountCoupon;

public class PercentageDiscountStrategy implements DiscountStrategy{
    private double percentage;

    public PercentageDiscountStrategy(double percentage){
        this.percentage=percentage;
    }

    @Override
    public double calculate(double baseAmt) {
        return (percentage/100)*baseAmt;
    }
}
package DiscountCoupon;

public class LoyaltyOffer extends Coupon {
    private double percentage;
    DiscountStrategy type;

    public LoyaltyOffer(double percentage){
        this.percentage=percentage;
        type=DiscountStrategyManager.getinstance().getStrategy(strategyType.PERCENT, percentage, 0.0);
    }

    @Override
    public boolean isApplicable(Cart cart) {
        return cart.getLoyalty();
    }

    @Override
    public double getDiscount(Cart cart) {
        // calculate karega humare disscount se phele wale sum pr discount ko
       return type.calculate(cart.getInitialTotal());
    }

    @Override
    public String name() {
         return "Loyalty Discount " + (int)percentage + "% off";
    }
    
}

package DiscountCoupon;

public class bulkPurchaseDiscount extends Coupon {
    private double threshold;
    private double flatoff;
    private DiscountStrategy type;

    public bulkPurchaseDiscount(double threshold,double flatoff){
        this.threshold=threshold;
        this.flatoff=flatoff;
       type= DiscountStrategyManager.getinstance().getStrategy(strategyType.FLAT, flatoff,0.0);
    }

    @Override
    public boolean isApplicable(Cart cart) {
        return cart.getFinalTotal()>=threshold;
    }

    @Override
    public double getDiscount(Cart cart) {
       return type.calculate(cart.getInitialTotal());
    }

    @Override
    public String name() {
         return "Bulk Purchase Rs " + (int)flatoff + " off over " + (int)threshold;
    }
    
}

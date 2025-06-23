package DiscountCoupon;

public class seasonalOffer extends Coupon {
    private double percentage;
    private String category;
    private DiscountStrategy type;


    public seasonalOffer(double percentage,String category){
        this.percentage=percentage;
        this.category=category;
        this.type=DiscountStrategyManager.getinstance().getStrategy(strategyType.PERCENT, percentage, 0.0);
    }


    @Override
    public boolean isApplicable(Cart cart) {
        for(CartItems items:cart.getItems()){
            if(items.getProduct().getCategory().equals(category)){
                return true;
            }
        }
        return false;
    }


    @Override
    public double getDiscount(Cart cart) {

        double subtotal=0.0;
        for(CartItems items:cart.getItems()){
            if(items.getProduct().getCategory().equals(category)){
                subtotal+=items.ItemTotal();
            }
        }
        return type.calculate(subtotal);
        // ab ja apne discount type se discount calulate kr given items pr 
    }


    @Override
    public String name() {
         return "Seasonal Offer " + (int)percentage + "% off " + category;
    }

    
}

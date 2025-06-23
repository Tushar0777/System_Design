package DiscountCoupon;

public class BankingCoupon extends Coupon {
    private String bank;
    private double minspend;
    private double percentage;
    private double offcap;
    DiscountStrategy type;

    public BankingCoupon(String bank,double minspend,double percentage,double offcap){
        this.bank=bank;
        this.minspend=minspend;
        this.percentage=percentage;
        this.offcap=offcap;
        type=DiscountStrategyManager.getinstance().getStrategy(strategyType.PERCENT_WITH_CAP, percentage, offcap);
    
    }

    @Override
    public boolean isApplicable(Cart cart) {
        if(cart.getBank().equals(bank)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public double getDiscount(Cart cart) {
        return type.calculate(cart.getInitialTotal());
    }

    @Override
    public String name() {
        return bank + " Bank Rs " + (int)percentage + " off upto " + (int)offcap;
    }
    
}

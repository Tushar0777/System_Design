package DiscountCoupon;

public abstract class Coupon {
    Coupon next;

    public Coupon(){
        next=null;
    }
    public void setNext(Coupon next){
        this.next=next;
    }
    public Coupon getNext(){
        return next;
    }

    public void applyDiscount(Cart cart){
        if(isApplicable(cart)){
            double discount=getDiscount(cart);
            cart.applyDiscount(discount);
            System.out.println(name() +" applied to "+discount );
            if(!isCombinable()){
                return;
            }

        }
        if(next!=null){
            next.applyDiscount(cart);
        }
    }
    public abstract boolean isApplicable(Cart cart);
    public abstract double getDiscount(Cart cart);
    public boolean isCombinable(){
        return true;
    }
    public abstract String name();
}

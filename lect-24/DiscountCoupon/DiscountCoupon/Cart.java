package DiscountCoupon;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItems>items=new ArrayList<>();
    private double initialTotal=0.0;
    private double finalTotal=0.0;
    private boolean isLoyalty;
    private String paymentbank;

    public Cart(){
        isLoyalty=false;
        paymentbank="";
    }
    public void addItems(Product p,int q){
        CartItems temp=new CartItems(p, q);
        items.add(temp);
        initialTotal+=p.getprize();
        finalTotal+=p.getprize();
    }
    public void setLoyalty(boolean member){
        isLoyalty=member;
    }
    public boolean getLoyalty(){
        return isLoyalty;
    }
    public void setBank(String bank){
        paymentbank=bank;
    }
    public String getBank(){
        return paymentbank;

    }
    public List<CartItems> getItems(){
        return items;
    }
    public double getInitialTotal(){
        return initialTotal;
    }
    public double getFinalTotal(){
        return finalTotal;
    }
    public void applyDiscount(double d) {
        initialTotal -= d;
        if (initialTotal < 0) {
            initialTotal = 0;
        }
    }

    
}

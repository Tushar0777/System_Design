package DiscountCoupon;
public class CartItems {
    private Product product;
    private int quantity;

    public CartItems(Product prod,int quan){
        product=prod;
        quantity=quan;
    }

    public int ItemTotal(){
        return product.getprize();
    }
    public int getquantity(){
        return quantity;
    }
    
}

package DiscountCoupon;

import java.util.List;

public class Main {
      public static void main(String[] args) {
        CouponManager mgr = CouponManager.getinstance();
        mgr.registerCoupon(new seasonalOffer(10, "Clothing"));
        mgr.registerCoupon(new LoyaltyOffer(5));
        mgr.registerCoupon(new bulkPurchaseDiscount(1000, 100));
        mgr.registerCoupon(new BankingCoupon("ABCD", 2000, 15, 500));

        Product p1 = new Product("kapde", "Clothing", 1000);
        Product p2 = new Product("phone", "Electronics", 20000);
        Product p3 = new Product("Jeans", "Clothing", 1000);
        Product p4 = new Product("lead", "Electronics", 2000);

        Cart cart = new Cart();
        cart.addItems(p1, 1);
        cart.addItems(p2, 1);
        cart.addItems(p3, 2);
        cart.addItems(p4, 1);
        cart.setLoyalty(true);
        cart.setBank("ABC");

        System.out.println("Original Cart Total: " + cart.getInitialTotal() + " Rs");

        List<String> applicable = mgr.getApplicable(cart);
        System.out.println("Applicable Coupons:");
        for (String name : applicable) {
            System.out.println(" - " + name);
        }

        double finalTotal = mgr.applyAll(cart);
        System.out.println("Final Cart Total after discounts: " + finalTotal + " Rs");
    }
}

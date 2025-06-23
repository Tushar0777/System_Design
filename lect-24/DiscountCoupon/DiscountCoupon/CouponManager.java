package DiscountCoupon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//<<singleton>>
public class CouponManager {
    private static CouponManager instance;
    private Coupon head;
    private final Lock lock = new ReentrantLock();

    private CouponManager(){
        this.head=null;
    }
    public static synchronized CouponManager getinstance(){
        if(instance== null){
            instance=new CouponManager();
        }
            return instance;
    }

    public void registerCoupon(Coupon coupon){
        lock.lock();

        try{
            if(head==null){
            head=coupon;
        }
        else{
            Coupon curr=head;
            while(curr.getNext()!=null){
               curr= curr.getNext();
            }
            curr.setNext(coupon);
        }

        }
        finally{
            lock.unlock();

        }
    }
    public List<String> getApplicable(Cart cart) {
        lock.lock();
        try {
            List<String> res = new ArrayList<>();
            Coupon cur = head;
            while (cur != null) {
                if (cur.isApplicable(cart)) {
                    res.add(cur.name());
                }
                cur = cur.getNext();
            }
            return res;
        } finally {
            lock.unlock();
        }
    }

        public double applyAll(Cart cart) {
        lock.lock();
        try {
            if (head != null) {
                head.applyDiscount(cart);
            }
            return cart.getInitialTotal();
        } finally {
            lock.unlock();
        }
    }


    
}

package DiscountCoupon;


enum strategyType{
    FLAT,
    PERCENT,
    PERCENT_WITH_CAP
}
//<<singleton>>
public class DiscountStrategyManager {
    private static DiscountStrategyManager instance;

    private DiscountStrategyManager(){};

    public static synchronized DiscountStrategyManager getinstance(){
        if(instance==null){
            instance=new DiscountStrategyManager();
        }
        return instance;
    }
    public DiscountStrategy getStrategy(strategyType st,double param1,double param2){

        switch(st){
            case FLAT:
                return new FlatDiscountStrategy(param1);
            
            case PERCENT:
                return new PercentageDiscountStrategy(param1);
            
            case PERCENT_WITH_CAP:
                return new PercentageCapDiscountStrategy(param1, param2);

            default:
                return null;
        
        
        }
    
    }
    
}

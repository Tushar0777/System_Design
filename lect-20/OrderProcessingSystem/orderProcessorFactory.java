package OrderProcessingSystem;

public class orderProcessorFactory {
    public static orderProcessor getorderprocessor(String platform){
            String tosearch=platform.toLowerCase();

            if(tosearch.equals("zomato")){
                return new zomatoOrder();
            }
            if(tosearch.equals("amazon")){
                return new amazonOrder();
            } else{
                System.out.println("not a valid platform");
            }
            return null;
    }
    
}

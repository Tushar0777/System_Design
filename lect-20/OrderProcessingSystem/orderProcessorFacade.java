package OrderProcessingSystem;

public class orderProcessorFacade {
  //  private orderProcessor orderprocessor;
   // private orderProcessorFactory orderprocessorfactory;
   public void placeOrder(String platform){
    orderProcessor company= orderProcessorFactory.getorderprocessor(platform);
   // amazon.getorderprocessor(platform);
    company.processorder();
   }
    
}

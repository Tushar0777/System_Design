package proxyDesignPattern;

interface picture {

   public void Display();
};

class RealSubject implements picture{
   public void Display(){
    System.out.println("RealMethod : loading an image");
   }

};

class proxySubject implements picture{
   private RealSubject pictureproxy;

    public void Display(){
        if(pictureproxy==null){
            pictureproxy=new RealSubject();
        // jab method call hoga tabhi object creating kara 
        // lazy loading 
        }
        System.out.println("proxy precoessing the data ");
        pictureproxy.Display();
        System.out.println("proxy forwarding the data from realsubject to user");
        
    }
};

public class proxyDesignPattern{
    public static void main(String[] args) {
        proxySubject client=new proxySubject();
        client.Display();
    }

};

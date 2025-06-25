package ZeptoLLD;

public class ProductFactory {
    // sku dalega uske corresponding products already present hai 

    public static Product createProduct(int sku){
        String name;
        double price;
        if(sku==101){
            name="apple";
            price=100000;
        }
        else if(sku==102){
            name="laptop";
            price=2000000;
        }
        else if(sku==103){
            name="ganne ka juice";
            price=20;
        }
        else if(sku==104){
            name="newton ka apple";
            price=100;
        }
        else{
            name="Item"+sku;
            price=100;
        }
        return new Product(sku, name, price);
    }
    
}

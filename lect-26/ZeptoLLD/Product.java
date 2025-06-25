package ZeptoLLD;

public class Product{
    private String name;
    private int sku;
    private double price;

    public Product(int sku,String name,double p){
        this.name=name;
        this.price=p;
        this.sku=sku;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getSku() {
        return sku;
    }

} 
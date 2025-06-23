package DiscountCoupon;

public class Product{
    private String name;
    private String category;
    private int prize;

    public Product(String name,String category,int prize){
        this.name=name;
        this.category=category;
        this.prize=prize;

    }
    public String getName(){
        return name;
    }
    public String getCategory(){
        return category;
    }
    public int getprize(){
        return prize;
    }
}
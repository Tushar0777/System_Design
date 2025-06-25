package ZeptoLLD.InventoryStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ZeptoLLD.Product;

public class DBinventoryStore implements InventoryStrore {
    private Map<Integer,Integer>stock;
    private Map<Integer,Product>products;


    public DBinventoryStore(){
        stock=new HashMap<>();
        products=new HashMap<>();
    }


    @Override
    public void addProduct(Product p, int q) {
        int sku=p.getSku();
        if(!products.containsKey(sku)){
            products.put(sku,p);
        }
        int currentstock=stock.getOrDefault(sku,0 );
        stock.put(sku,currentstock+q);
       
    }

    @Override
    public void removeProduct(int sku, int q) {
        if(stock.containsKey(sku)){
           return ;
        }
        int currentstock=stock.getOrDefault(sku, 0);
        if(currentstock-q>0){
            stock.put(sku,currentstock-q);
        }
        else{
            stock.remove(sku);
            products.remove(sku);
        }
    }

    @Override
    public int checkStore(int sku) {
       return stock.getOrDefault(sku, 0);
    }

    @Override
    public List<Product> listAvailableProduct() {
        List<Product>result=new ArrayList();
        for(Map.Entry<Integer,Integer>it:stock.entrySet()){
            int sku=it.getKey();
            int q=it.getValue();
            if(q>0 && products.containsKey(sku)){
                result.add(products.get(sku));

            }
        }
        return result;
    }

    
}

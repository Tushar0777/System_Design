package ZeptoLLD.InventoryStore;

import java.util.List;

import ZeptoLLD.Product;

public interface InventoryStrore {
    public void addProduct(Product p,int q);
    public void removeProduct(int sku,int q);
    int checkStore(int sku);
    List<Product>listAvailableProduct();
}

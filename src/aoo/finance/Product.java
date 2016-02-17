package aoo.finance;

public class Product {
    
    private static int id = 100;
    private int productId;
    
    public Product() {
        productId = id++;
    }

    public int getProductId() {
        return productId;
    }
    
}

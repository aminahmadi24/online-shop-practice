package ir.aminahmadi24.repository;

import ir.aminahmadi24.model.Product;
import ir.aminahmadi24.utility.DynamicArray;

public class ProductRepository {
    private static final DynamicArray PRODUCTS_ARRAY = new DynamicArray("Product");
    public boolean save(Product product){
        return PRODUCTS_ARRAY.add(product);
    }
    public int getId(){
        return PRODUCTS_ARRAY.getSize() + 1;
    }
}

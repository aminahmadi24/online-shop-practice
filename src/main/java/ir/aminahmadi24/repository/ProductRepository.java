package ir.aminahmadi24.repository;

import ir.aminahmadi24.dto.ProductWithCategory;
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

    public Product findByName(String name){
        for (int i = 0; i < PRODUCTS_ARRAY.getSize(); i++) {
            Product p = (Product) PRODUCTS_ARRAY.getByIndex(i);
            if(p.getName().equalsIgnoreCase(name))
                return p;
        }
        return null;
    }

    public Product findById(int id){
        for (int i = 0; i < PRODUCTS_ARRAY.getSize(); i++) {
            Product p = (Product) PRODUCTS_ARRAY.getByIndex(i);
            if(p.getId() == id)
                return p;
        }
        return null;
    }

    public DynamicArray findByCategoryId(int categoryId){
        DynamicArray products = new DynamicArray("Product");
        for (int i = 0; i < PRODUCTS_ARRAY.getSize(); i++) {
            Product p = (Product) PRODUCTS_ARRAY.getByIndex(i);
            if(p.getCategoryId() == categoryId)
                products.add(p);
        }
        return products;
    }

    public boolean decreaseStockQuantity(int id){
        for (int i = 0; i < PRODUCTS_ARRAY.getSize(); i++) {
            Product p = (Product) PRODUCTS_ARRAY.getByIndex(i);
            if(p.getId() == id){
                p.setStockQuantity(p.getStockQuantity() - 1);
                return true;
            }
        }
        return false;
    }

    public int getPriceById(int id){
        for (int i = 0; i < PRODUCTS_ARRAY.getSize(); i++) {
            Product p = (Product) PRODUCTS_ARRAY.getByIndex(i);
            if(p.getId() == id)
                return p.getPrice();
        }
        return -1;
    }

    public DynamicArray getProductsByIds(DynamicArray productsIds){
        DynamicArray products = new DynamicArray("Product");
        for (int i = 0; i < PRODUCTS_ARRAY.getSize(); i++) {
            Product p = (Product) PRODUCTS_ARRAY.getByIndex(i);
            for (int j = 0; j < productsIds.getSize(); j++) {
                if(p.getId() == (int) productsIds.getByIndex(j)){
                    products.add(p);
                }
            }
        }
        return products;
    }

}

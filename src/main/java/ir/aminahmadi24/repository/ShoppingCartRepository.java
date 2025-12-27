package ir.aminahmadi24.repository;

import ir.aminahmadi24.model.ShoppingCart;
import ir.aminahmadi24.utility.DynamicArray;

public class ShoppingCartRepository {
    private static final DynamicArray SHOPPING_CARTS = new DynamicArray("ShoppingCart");
    public boolean save(ShoppingCart shoppingCart){
        return SHOPPING_CARTS.add(shoppingCart);
    }
    public int getId(){
        return SHOPPING_CARTS.getSize() + 1;
    }

    public ShoppingCart findById(int id) {
        for (int i = 0; i < SHOPPING_CARTS.getSize(); i++) {
            ShoppingCart shoppingCart = (ShoppingCart) SHOPPING_CARTS.getByIndex(i);
            if(shoppingCart.getId() == id)
                return shoppingCart;
        }
        return null;
    }
}

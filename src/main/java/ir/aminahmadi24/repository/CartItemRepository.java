package ir.aminahmadi24.repository;

import ir.aminahmadi24.model.CartItem;
import ir.aminahmadi24.utility.DynamicArray;

public class CartItemRepository {
    private static final DynamicArray PRODUCT_SHOPPING_CART = new DynamicArray("CartItem");

    public boolean save(CartItem cartItem){
        return PRODUCT_SHOPPING_CART.add(cartItem);
    }

    public int getId(){
        return PRODUCT_SHOPPING_CART.getSize() + 1;
    }
}

package ir.aminahmadi24.repository;

import ir.aminahmadi24.model.CartItem;
import ir.aminahmadi24.model.Product;
import ir.aminahmadi24.utility.DynamicArray;

public class CartItemRepository {
    private static final DynamicArray CART_ITEMS = new DynamicArray("CartItem");

    public boolean save(CartItem cartItem){
        return CART_ITEMS.add(cartItem);
    }

    public int getId(){
        return CART_ITEMS.getSize() + 1;
    }

    public DynamicArray findShoppingCartProductIds(int shoppingCartId){
        DynamicArray productsIds = new DynamicArray("Integer");
        for (int i = 0; i < CART_ITEMS.getSize(); i++) {
            CartItem cartItem = (CartItem) CART_ITEMS.getByIndex(i);
            if(cartItem.getShoppingCartId() == shoppingCartId)
                productsIds.add(cartItem.getProductId());
        }
        return productsIds;
    }
}

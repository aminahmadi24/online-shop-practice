package ir.aminahmadi24.service;

import ir.aminahmadi24.model.Product;
import ir.aminahmadi24.model.CartItem;
import ir.aminahmadi24.model.ShoppingCart;
import ir.aminahmadi24.repository.CartItemRepository;
import ir.aminahmadi24.utility.DynamicArray;

public class CartItemService {
    private final CartItemRepository cartItemRepository;
    private ProductService productService;
    private ShoppingCartService shoppingCartService;

    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public void setProductService(ProductService productService){
        this.productService = productService;
    }

    public void setShoppingCartService(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    public boolean add(int productId, int shoppingCartId){
        Product product = productService.findById(productId);
        if(product == null)
            return false;
        if(product.getStockQuantity() < 1)
            return false;
        ShoppingCart shoppingCart = shoppingCartService.findById(shoppingCartId);
        if(shoppingCart == null)
            return false;
        CartItem cartItem = new CartItem(productId, shoppingCartId);
        cartItem.setId(cartItemRepository.getId());
        return cartItemRepository.save(cartItem);
    }
    public DynamicArray findShoppingCartProductIds(int shoppingCartId){
        return cartItemRepository.findShoppingCartProductIds(shoppingCartId);
    }

}

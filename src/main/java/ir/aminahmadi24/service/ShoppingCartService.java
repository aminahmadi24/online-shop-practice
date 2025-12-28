package ir.aminahmadi24.service;

import ir.aminahmadi24.model.Product;
import ir.aminahmadi24.model.ShoppingCart;
import ir.aminahmadi24.repository.ShoppingCartRepository;
import ir.aminahmadi24.utility.DynamicArray;

public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private CartItemService cartItemService;
    private ProductService productService;
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository){
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public void setCartItemService(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public boolean add(ShoppingCart shoppingCart){
        shoppingCart.setId(shoppingCartRepository.getId());
        return shoppingCartRepository.save(shoppingCart);
    }

    public ShoppingCart findById(int id){
        return shoppingCartRepository.findById(id);
    }

    public int calculateTotalPrice(int id){
        ShoppingCart shoppingCart = shoppingCartRepository.findById(id);
        if(shoppingCart == null)
            return -1;
        DynamicArray shoppingCartProductIds = cartItemService.findShoppingCartProductIds(id);
        int totalPrice = 0;
        DynamicArray products = productService.getProductsByIds(shoppingCartProductIds);
        for (int i = 0; i < products.getSize(); i++) {
            totalPrice += ((Product)products.getByIndex(i)).getPrice();
        }
        return totalPrice;
    }
    public boolean processShoppingCart(int id){
        DynamicArray shoppingCartProductIds = cartItemService.findShoppingCartProductIds(id);
        productService.decreaseStockQuantity(shoppingCartProductIds);
        return true;
    }
}

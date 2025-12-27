package ir.aminahmadi24.service;

import ir.aminahmadi24.model.ShoppingCart;
import ir.aminahmadi24.repository.ShoppingCartRepository;

public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository){
        this.shoppingCartRepository = shoppingCartRepository;
    }
    public boolean add(ShoppingCart shoppingCart){
        shoppingCart.setId(shoppingCartRepository.getId());
        return shoppingCartRepository.save(shoppingCart);
    }

    public ShoppingCart findById(int id){
        return shoppingCartRepository.findById(id);
    }
}

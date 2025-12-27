package ir.aminahmadi24.model;

public class CartItem {
    private int id;
    private int productId;
    private int shoppingCartId;

    public CartItem(int productId, int shoppingCartId){
        this.productId = productId;
        this.shoppingCartId = shoppingCartId;
    }

    public void setId(int id) {
        this.id = id;
    }
}

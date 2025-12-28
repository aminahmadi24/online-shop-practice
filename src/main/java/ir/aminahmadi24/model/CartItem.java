package ir.aminahmadi24.model;

public class CartItem {
    private int id;
    private int productId;
    private int shoppingCartId;

    public CartItem(int productId, int shoppingCartId){
        this.productId = productId;
        this.shoppingCartId = shoppingCartId;
    }

    public int getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    public int getShoppingCartId() {
        return shoppingCartId;
    }

    public void setId(int id) {
        this.id = id;
    }
}

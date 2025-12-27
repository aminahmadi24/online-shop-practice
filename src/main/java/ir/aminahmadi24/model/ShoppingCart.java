package ir.aminahmadi24.model;

import java.time.LocalDateTime;

public class ShoppingCart {
    private int id;
    private int totalPrice;
    private LocalDateTime registrationDate;
    private int customerId;

    public ShoppingCart(int customerId) {
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

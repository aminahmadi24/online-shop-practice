package ir.aminahmadi24;

import ir.aminahmadi24.enums.ProductSortType;
import ir.aminahmadi24.model.*;
import ir.aminahmadi24.repository.*;
import ir.aminahmadi24.service.*;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer(
                "Amin", "amin@gmail.com", "Asf23@hsk", "Tehran");
        Customer customer2 = new Customer(
                "Reza", "reza@gmail.com", "As2223@hsk", "Shiraz");

        CustomerService customerService = new CustomerService(new CustomerRepository());

        Category category1 = new Category("Mobile");
        Category category2 = new Category("Appliances");
        CategoryService categoryService = new CategoryService(new CategoryRepository());

        Product product1 = new Product("S22", 120, "A good phone", 13);
        Product product2 = new Product(
                "Vacuum cleaner", 401, "It's the best", 7);
        Product product3 = new Product(
                "Coffee maker", 42, "It's great", 32);
        Product product4 = new Product(
                "P30 pro", 75, "It's the best", 11);
        ProductService productService = new ProductService(new ProductRepository());
        productService.setCategoryService(categoryService);



        System.out.println("Customer registration: ");
        System.out.println(customerService.signUp(customer1));
        System.out.println(customerService.signUp(customer2));
        System.out.println();

        System.out.println("Customer sign in: ");
        System.out.println(customerService.signIn("amin@gmail.com", "Asf23@hsk"));
        System.out.println();

        System.out.println("Customer update address: ");
        System.out.println(customerService.updateAddress("amin@gmail.com", "Asf23@hsk",
                "Var"));
        System.out.println();

        System.out.println("Add a category: ");
        System.out.println(categoryService.add(category1));
        System.out.println(categoryService.add(category2));
        System.out.println();

        System.out.println("Add a product: ");
        System.out.println(productService.add(product1, "Mobile"));
        System.out.println(productService.add(product2, "Appliances"));
        System.out.println(productService.add(product3, "Appliances"));
        System.out.println(productService.add(product4, "Mobile"));
        System.out.println();

        System.out.println("Find a product by name: ");
        System.out.println(productService.findByName("s22"));
        System.out.println();

        System.out.println("Find sorted products of a category: ");
        Product[] products = productService.
                findSortedProductsByCategoryTitle("Appliances", ProductSortType.DESC);
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i]);
        }
        System.out.println();

        ShoppingCart shoppingCart = new ShoppingCart(1);
        ShoppingCartService shoppingCartService = new ShoppingCartService(new ShoppingCartRepository());
        shoppingCartService.setProductService(productService);
        System.out.println("Create a shopping cart and add products to it: ");
        System.out.println(shoppingCartService.add(shoppingCart));
        System.out.println();

        System.out.println("Add a product to a shopping cart: ");
        CartItemService cartItemService = new CartItemService(new CartItemRepository());
        cartItemService.setProductService(productService);
        cartItemService.setShoppingCartService(shoppingCartService);
        shoppingCartService.setCartItemService(cartItemService);
        System.out.println(cartItemService.add(1, 1));
        System.out.println(cartItemService.add(2, 1));
        System.out.println();

        System.out.println("Calculate shopping cart total price: ");
        System.out.println(shoppingCartService.calculateTotalPrice(shoppingCart.getId()));
    }
}

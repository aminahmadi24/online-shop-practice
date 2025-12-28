package ir.aminahmadi24.service;

import ir.aminahmadi24.dto.ProductWithCategory;
import ir.aminahmadi24.enums.ProductSortType;
import ir.aminahmadi24.model.Product;
import ir.aminahmadi24.repository.ProductRepository;
import ir.aminahmadi24.utility.DynamicArray;

public class ProductService {
    private final ProductRepository productRepository;
    private CategoryService categoryService;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public boolean add(Product product, String categoryTitle) {
        int idByTitle = categoryService.getIdByTitle(categoryTitle);
        if (idByTitle == -1)
            return false;
        product.setCategoryId(idByTitle);
        product.setId(productRepository.getId());
        return productRepository.save(product);
    }

    public ProductWithCategory findByName(String name) {
        Product product = productRepository.findByName(name);
        if (product == null)
            return null;
        String categoryTitle = categoryService.getTitleById(product.getId());
        if (categoryTitle == null)
            return null;
        return new ProductWithCategory(product.getName(),
                product.getPrice(), product.getDescription(), categoryTitle);
    }

    public Product findById(int id){
        return productRepository.findById(id);
    }

    public Product[] findSortedProductsByCategoryTitle(String categoryTitle, ProductSortType productSortType) {
        int categoryId = categoryService.getIdByTitle(categoryTitle);
        if (categoryId == -1)
            return null;
        DynamicArray productsDynamicArray = productRepository.findByCategoryId(categoryId);
        Product[] productsArray = convertProductsDynamicArrayToArray(productsDynamicArray);
        if(productSortType == ProductSortType.ASC)
            return sortProductsAsc(productsArray);
        else
            return sortProductsDesc(productsArray);
    }

    private Product[] convertProductsDynamicArrayToArray(DynamicArray productsDynamicArray) {
        Product[] productsArray = new Product[productsDynamicArray.getSize()];
        for (int i = 0; i < productsArray.length; i++) {
            productsArray[i] = (Product) productsDynamicArray.getByIndex(i);
        }
        return productsArray;
    }

    private Product[] sortProductsAsc(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            for (int j = i; j < products.length; j++) {
                if (products[i].getPrice() > products[j].getPrice()) {
                    Product temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
        return products;
    }

    private Product[] sortProductsDesc(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            for (int j = i; j < products.length; j++) {
                if (products[i].getPrice() < products[j].getPrice()) {
                    Product temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
        return products;
    }

    public boolean decreaseStockQuantity(int id){
        return productRepository.decreaseStockQuantity(id);
    }

    public int getPriceById(int id){
        return productRepository.getPriceById(id);
    }
    public DynamicArray getProductsByIds(DynamicArray productsIds){
        return productRepository.getProductsByIds(productsIds);
    }
}

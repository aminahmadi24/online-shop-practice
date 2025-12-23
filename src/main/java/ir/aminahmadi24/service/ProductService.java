package ir.aminahmadi24.service;

import ir.aminahmadi24.model.Product;
import ir.aminahmadi24.repository.ProductRepository;

public class ProductService {
    private final ProductRepository productRepository;
    private CategoryService categoryService;
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public void setCategoryService(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    public boolean add(Product product, String categoryTitle){
        int idByTitle = categoryService.getIdByTitle(categoryTitle);
        if(idByTitle == -1)
            return false;
        product.setCategoryId(idByTitle);
        product.setId(productRepository.getId());
        return productRepository.save(product);
    }
}

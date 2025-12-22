package ir.aminahmadi24.service;

import ir.aminahmadi24.model.Category;
import ir.aminahmadi24.repository.CategoryRepository;

public class CategoryService {
    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    public boolean add(Category category){
        if(category.getTitle().length() < 3)
            return false;
        if(categoryRepository.isTitleDuplicated(category.getTitle()))
            return false;
        category.setId(categoryRepository.getId());
        return categoryRepository.save(category);
    }

}

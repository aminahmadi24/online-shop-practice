package ir.aminahmadi24.repository;

import ir.aminahmadi24.model.Category;
import ir.aminahmadi24.utility.DynamicArray;

public class CategoryRepository {
    private static final DynamicArray CATEGORIES_ARRAY = new DynamicArray("Category");
    public boolean save(Category category){
        return CATEGORIES_ARRAY.add(category);
    }
    public Category findByTitle(String title){
        for (int i = 0; i < CATEGORIES_ARRAY.getSize(); i++) {
            Category c = (Category) CATEGORIES_ARRAY.getByIndex(i);
            if(c.getTitle().equals(title))
                return c;
        }
        return null;
    }
    public boolean isTitleDuplicated(String title){
        for (int i = 0; i < CATEGORIES_ARRAY.getSize(); i++) {
            Category c = (Category) CATEGORIES_ARRAY.getByIndex(i);
            if(c.getTitle().equals(title))
                return true;
        }
        return false;
    }
    public int getId(){
        return CATEGORIES_ARRAY.getSize() + 1;
    }
}

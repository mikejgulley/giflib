package com.lumatikmedia.giflib.data;

import com.lumatikmedia.giflib.model.Category;
import com.lumatikmedia.giflib.model.Gif;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mgulley on 5/11/2016.
 */
@Component
public class CategoryRepository {
    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
        new Category(1, "Technology"),
        new Category(2, "People"),
        new Category(3, "Destruction")
    );

    public Category findCategoryById(int id) {
        for(Category category : ALL_CATEGORIES) {
            if(category.getId() == id) {
                return category;
            }
        }
        return null;
    }

    public List<Category> getAllCategories() {
        return ALL_CATEGORIES;
    }

}

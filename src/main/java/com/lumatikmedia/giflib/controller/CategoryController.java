package com.lumatikmedia.giflib.controller;

import com.lumatikmedia.giflib.data.CategoryRepository;
import com.lumatikmedia.giflib.data.GifRepository;
import com.lumatikmedia.giflib.model.Category;
import com.lumatikmedia.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by mgulley on 5/11/2016.
 */
@Controller
public class CategoryController {
    @Autowired // Dependency Injection (D.I.)
    CategoryRepository categoryRepository = new CategoryRepository();

    @Autowired
    GifRepository gifRepository;

    @RequestMapping("/categories")
    public String listCategories(ModelMap modelMap) {
        List<Category> categories = categoryRepository.getAllCategories();
        modelMap.put("categories", categories);
        return "categories";
    }

    @RequestMapping("/category/{id}")
    public String category(@PathVariable int id, ModelMap modelMap) {
        Category category = categoryRepository.findCategoryById(id);
        modelMap.put("category", category);

        List<Gif> gifs = gifRepository.findByCategoryId(id);
        modelMap.put("gifs", gifs);

        return "category";
    }
}

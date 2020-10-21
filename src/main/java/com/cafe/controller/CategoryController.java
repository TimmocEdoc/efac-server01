package com.cafe.controller;

import com.cafe.entity.Category;
import com.cafe.entity.Product;
import com.cafe.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Category> ListCategory() {
        return categoryService.CategoryList();
    }

    @RequestMapping(value = "details/{id}", method = RequestMethod.GET)
    public Category detailsCategory(@PathVariable int id) {
        return categoryService.GetCategory(id);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<?> createCategory(@Valid @RequestBody Category category) {
        categoryService.SaveCategory(category);
        return ResponseEntity.ok("success!");
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCategory(@Valid @RequestBody Category category) {
        categoryService.SaveCategory(category);
        return ResponseEntity.ok("success!");
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
        categoryService.DeleteCategory(id);
        return ResponseEntity.ok("success!");
    }
}

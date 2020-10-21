package com.cafe.service;

import com.cafe.entity.Category;
import com.cafe.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> CategoryList() {
        return repository.findAll();
    }

    public Category GetCategory(int id){
        return repository.findById(id).orElse(null);
    }

    public void SaveCategory(Category category) {
        repository.save(category);
    }

    public void DeleteCategory(Integer id){
        Optional<Category> category = repository.findById(id);
        category.get().setProducts(null);
        repository.deleteById(id);
    }
}

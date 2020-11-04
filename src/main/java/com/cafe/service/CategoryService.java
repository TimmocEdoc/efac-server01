package com.cafe.service;

import com.cafe.dto.CategoryDto;
import com.cafe.entity.Category;
import com.cafe.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<CategoryDto> CategoryList() {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category c: repository.findAll()) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setCategory(c);
            categoryDto.setProducts(c.getProducts());
            categoryDtos.add(categoryDto);
        }
        return categoryDtos;
    }

    public CategoryDto GetCategory(int id){
        Category c = repository.findById(id).orElse(null);
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategory(c);
        if (c != null) {
            categoryDto.setProducts(c.getProducts());
        }
        return categoryDto;
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

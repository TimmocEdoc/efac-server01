package com.cafe.service;

import com.cafe.entity.Category;
import com.cafe.entity.Product;
import com.cafe.repository.CategoryRepository;
import com.cafe.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    public ProductRepository repository;
    public CategoryRepository categoryRepository;

    public ProductService(ProductRepository repository, CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        this.repository = repository;
    }

    public List<Product> ProductList() {
        return repository.findAll();
    }

    public Product GetProduct(String id){
        return repository.findById(id).orElse(null);
    }

    public void SaveProduct(Product product, Integer id) {
        Optional<Category> c = categoryRepository.findById(id);
        if(c.isPresent()){
            product.setCategory(c.get());
        }
        repository.save(product);
    }

    public void DeleteProduct(String id){
        repository.deleteById(id);
    }
}

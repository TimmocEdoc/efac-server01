package com.cafe.service;

import com.cafe.dto.ProductDto;
import com.cafe.entity.Category;
import com.cafe.entity.Product;
import com.cafe.repository.CategoryRepository;
import com.cafe.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<ProductDto> ProductList() {
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product p:repository.findAll()) {
            ProductDto productDto = new ProductDto();
            productDto.setProduct(p);
            productDto.setCategory_name(p.getCategory().getName());
            productDto.setCategory_id(p.getCategory().getId());
            productDtos.add(productDto);
        }
        return productDtos;
    }

    public ProductDto GetProduct(String id){
        Product p = repository.findById(id).orElse(null);
        ProductDto productDto = new ProductDto();
        if(p != null) {
            productDto.setProduct(p);
            productDto.setCategory_name(p.getCategory().getName());
            productDto.setCategory_id(p.getCategory().getId());
        }
        return productDto;
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

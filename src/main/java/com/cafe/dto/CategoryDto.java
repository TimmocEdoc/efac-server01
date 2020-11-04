package com.cafe.dto;

import com.cafe.entity.Category;
import com.cafe.entity.Product;

import java.util.List;
import java.util.Set;

public class CategoryDto {
    private Category category;
    private Set<Product> products;

    public CategoryDto() {
    }

    public CategoryDto(Category category, Set<Product> products) {
        this.category = category;
        this.products = products;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}

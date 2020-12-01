package com.cafe.dto;

import com.cafe.entity.Category;
import com.cafe.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class CategoryDto {
    private Category category;
    private List<HashMap<String, String>> products = new ArrayList<>();

    public CategoryDto() {
    }

    public CategoryDto(Category category, List<HashMap<String, String>> products) {
        this.category = category;
        this.products = products;
    }

    public List<HashMap<String, String>> getProducts() {
        return products;
    }

    public void setProducts(List<HashMap<String, String>> products) {
        this.products = products;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

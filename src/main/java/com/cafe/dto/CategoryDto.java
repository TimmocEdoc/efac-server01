package com.cafe.dto;

import com.cafe.entity.Category;
import com.cafe.entity.Product;

import java.util.List;
import java.util.Set;

public class CategoryDto {
    private Category category;
    private List<String> product_names;

    public CategoryDto() {
    }

    public CategoryDto(Category category, List<String> product_names) {
        this.category = category;
        this.product_names = product_names;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<String> getProduct_names() {
        return product_names;
    }

    public void setProduct_names(List<String> product_names) {
        this.product_names = product_names;
    }
}

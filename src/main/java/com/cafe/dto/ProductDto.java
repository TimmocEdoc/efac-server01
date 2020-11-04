package com.cafe.dto;

import com.cafe.entity.Category;
import com.cafe.entity.Product;

public class ProductDto {
    private Product product;
    private Category category;

    public ProductDto(Product product, Category category) {
        this.product = product;
        this.category = category;
    }

    public ProductDto() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

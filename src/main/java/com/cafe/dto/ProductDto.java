package com.cafe.dto;

import com.cafe.entity.Category;
import com.cafe.entity.Product;

public class ProductDto {
    private Product product;
    private String category_name;

    public ProductDto() {
    }

    public ProductDto(Product product, String category_name) {
        this.product = product;
        this.category_name = category_name;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}

package com.cafe.dto;

import com.cafe.entity.Category;
import com.cafe.entity.Product;

import java.util.HashMap;

public class ProductDto {
    private Product product;
    private String category_name;
    private int category_id;

    public ProductDto() {
    }

    public ProductDto(Product product, String category_name, int category_id) {
        this.product = product;
        this.category_name = category_name;
        this.category_id = category_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
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

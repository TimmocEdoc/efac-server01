package com.cafe.controller;

import com.cafe.entity.Category;
import com.cafe.entity.Product;
import com.cafe.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    public ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Product> ListProduct() {
        return productService.ProductList();
    }

    @RequestMapping(value = "details/{id}", method = RequestMethod.GET)
    public Product detailsProduct(@PathVariable String id) {
        return productService.GetProduct(id);
    }

    @RequestMapping(value = "create/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> createProduct(@Valid @RequestBody Product product, @PathVariable Integer id) {
        productService.SaveProduct(product, id);
        return ResponseEntity.ok("success!");
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProduct(@Valid @RequestBody Product product, @PathVariable Integer id) {
        productService.SaveProduct(product, id);
        return ResponseEntity.ok("success!");
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable String id) {
        productService.DeleteProduct(id);
        return ResponseEntity.ok("success!");
    }
}

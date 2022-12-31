package com.example.csms.service;


import com.example.csms.bean.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    void deleteProduct(int productId);
    Product findProduct(int productId);
    void modifyProduct(Product product);
    List<Product> queryProducts();
}

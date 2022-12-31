package com.example.csms.mapper;


import com.example.csms.bean.Product;

import java.util.List;

public interface ProductMapper {
    void addProduct(Product product);
    void deleteProduct(int productId);
    Product findProduct(int productId);
    void modifyProduct(Product product);
    List<Product> queryProducts();
}

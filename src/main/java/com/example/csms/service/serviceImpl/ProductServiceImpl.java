package com.example.csms.service.serviceImpl;

import com.example.csms.bean.Product;
import com.example.csms.mapper.ProductMapper;
import com.example.csms.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;
    @Override
    public void addProduct(Product product) {
        productMapper.addProduct(product);
    }

    @Override
    public void deleteProduct(int productId) {
        productMapper.deleteProduct(productId);
    }

    @Override
    public Product findProduct(int productId) {
        return productMapper.findProduct(productId);
    }

    @Override
    public void modifyProduct(Product product) {
        productMapper.modifyProduct(product);
    }

    @Override
    public List<Product> queryProducts() {
        return productMapper.queryProducts();
    }
}

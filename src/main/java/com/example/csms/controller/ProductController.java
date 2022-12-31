package com.example.csms.controller;


import com.example.csms.bean.Product;
import com.example.csms.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {
    @Resource
    private ProductService productService;

    @RequestMapping(value = "/ModifyProduct", name = "modify",method = RequestMethod.POST)
    @ResponseBody
    public void modifyProduct(Product product){
        productService.modifyProduct(product);
    }


    @RequestMapping(value = "/AddProduct", name="add",method= RequestMethod.POST)
    @ResponseBody
    public String addProduct(Product product){
        if (product==null)
            return "404.html";
        productService.addProduct(product);
        return null;
    }
}

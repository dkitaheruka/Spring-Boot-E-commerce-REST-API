package com.getfocused.ecomerceRESTAPI.service;

import com.getfocused.ecomerceRESTAPI.model.Product;
import com.getfocused.ecomerceRESTAPI.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public List<Product> getProducts(){
        return productRepo.findAll();
    }

    public Product getProductById(int id){
        return productRepo.findById(id).orElse(new Product(0,"The product is not found", 0));
    }

    public void addProduct(Product product){
        productRepo.save(product);
    }

    public void updateProduct(Product product){
        productRepo.save(product);
    }

    public void deleteProduct(int id){
        productRepo.deleteById(id);
    }
}

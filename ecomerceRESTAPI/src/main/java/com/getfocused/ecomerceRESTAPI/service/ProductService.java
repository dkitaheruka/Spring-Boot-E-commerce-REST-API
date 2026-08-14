package com.getfocused.ecomerceRESTAPI.service;

import com.getfocused.ecomerceRESTAPI.model.Product;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products =  new ArrayList<>(Arrays.asList(
            new Product(101,"Iphone",150),
            new Product(102,"Wifi",340),
            new Product(103,"Computer",560)
            ));

    public List<Product> getProducts(){
        return products;
    }

    public Product getProductById(int id){
        return products.stream()
                .filter(p -> p.getProdid() == id)
                .findFirst().orElse(null);
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void updateProduct(Product product){
        int index = 0;
        for(int i = 0; i<products.size(); i++){
            if(products.get(i).getProdid() == product.getProdid()){
                index = i;
            }
        }
        products.set(index, product);
    }

    public void deleteProduct(int id){
        int index = 0;
        for(int i = 0; i<products.size(); i++){
            if(products.get(i).getProdid() == id){
                index = i;
            }
        }
        products.remove(index);
    }
}

package com.getfocused.ecomerceRESTAPI.service;

import com.getfocused.ecomerceRESTAPI.model.Product;
import com.getfocused.ecomerceRESTAPI.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public List<Product> getProducts(){
        return productRepo.findAll();
    }

    public Product getProductById(int id){
        return productRepo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return productRepo.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        if (!productRepo.existsById(id)) {
            return null;
        }
        product.setId(id);
        product.setImageData(imageFile.getBytes());
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        return productRepo.save(product);
    }

    public void deleProduct(int id) {
        productRepo.deleteById(id);
    }

    public List<Product> searchProduct(String keyword){
        return productRepo.searchProduct(keyword);
    }
}

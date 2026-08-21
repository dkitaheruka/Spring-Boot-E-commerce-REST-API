package com.getfocused.ecomerceRESTAPI.controller;

import com.getfocused.ecomerceRESTAPI.model.Product;
import com.getfocused.ecomerceRESTAPI.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity <List<Product>> getProducts(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity <Product> getProductById(@PathVariable int id){
        Product product = productService.getProductById(id);
        if(product == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
        try{
            Product product1 = productService.addProduct(product, imageFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("product/{productId}/image")
    public ResponseEntity<byte[]> getProductImageByProductId(@PathVariable int productId){
        Product product = productService.getProductById(productId);
        if(product == null || product.getImageData() == null || product.getImageType() == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        byte[] imageFile = product.getImageData();
        return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(imageFile);
    }

    @PutMapping("product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id,
                                                @RequestPart Product product,
                                                @RequestPart MultipartFile imageFile) throws IOException {
        Product product1 = productService.updateProduct(id, product, imageFile);
        if(product1 == null){
            return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        }
    }

    @DeleteMapping("product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Product product = productService.getProductById(id);
        if(product == null){
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
        else{
            productService.deleProduct(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
    }

    @GetMapping("products/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam String keyword){
        List<Product> products = productService.searchProduct(keyword);
        return  new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

}

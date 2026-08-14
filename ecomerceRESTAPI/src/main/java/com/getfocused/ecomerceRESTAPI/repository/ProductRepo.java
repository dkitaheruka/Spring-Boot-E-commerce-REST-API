package com.getfocused.ecomerceRESTAPI.repository;

import com.getfocused.ecomerceRESTAPI.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}

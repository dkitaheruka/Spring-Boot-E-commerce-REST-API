package com.getfocused.ecomerceRESTAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
public class Product {
    @Id
    private int prodid;
    private String prodname;
    private double prodprice;
}

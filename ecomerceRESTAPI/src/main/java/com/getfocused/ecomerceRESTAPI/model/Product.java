package com.getfocused.ecomerceRESTAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Product {
    private int prodid;
    private String prodname;
    private double prodprice;
}

package com.dh.productservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Value("${server.port}")
    private String port;

    @GetMapping
    public String getProduct() {
        return "Product123";
    }

    @GetMapping("/port")
    public String getPort() {
        return "The port is: " + port;
    }
}

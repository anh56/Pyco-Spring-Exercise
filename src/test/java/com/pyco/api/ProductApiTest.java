package com.pyco.api;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductApiTest {

    @Autowired
    ProductApi productApi;

    @DisplayName("Test hello function")
    @Test
    void getAllProductsTest(){
    }


}

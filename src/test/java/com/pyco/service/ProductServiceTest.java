package com.pyco.service;


import com.pyco.common.GenericResponse;
import com.pyco.dto.ProductDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @DisplayName("Test getAllProducts function")
    @Test
    void getAllProductTest(){
        GenericResponse genericResponse = productService.getAllProducts();

        if(genericResponse.getData()!= null){
            assertEquals(genericResponse.getErrorCode(), 200);
        }
        else assertEquals(genericResponse.getErrorCode(), 404);
    }


    @DisplayName("Test addProduct function")
    @Test
    void addProductTest(){
        ProductDto productDto = new ProductDto(1, 1, "Product A");
        GenericResponse genericResponse = productService.addProduct(productDto);
        if(genericResponse.getErrorCode()!= 404){
            assertEquals(genericResponse.getData(), productDto);
        }
        else assertEquals(genericResponse.getData(), null);
    }
}

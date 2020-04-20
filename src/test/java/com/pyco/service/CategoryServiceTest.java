package com.pyco.service;


import com.pyco.common.GenericResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
    public class CategoryServiceTest {


        @Autowired
        private CategoryService categoryService;

        @DisplayName("Test getAllCategoryTest function")
        @Test
        void getAllCategoryTest(){
            GenericResponse genericResponse = categoryService.getListOfCategory();
            if(genericResponse.getData()!= null){
                assertEquals(genericResponse.getErrorCode(), 200);
            }
            else assertEquals(genericResponse.getErrorCode(), 404);
        }








}

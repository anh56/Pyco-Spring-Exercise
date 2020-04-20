package com.pyco.api;


import com.pyco.common.GenericResponse;
import com.pyco.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryApi {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("categories/all")
    public GenericResponse getAllCategory(){
        return categoryService.getListOfCategory();
    }
}

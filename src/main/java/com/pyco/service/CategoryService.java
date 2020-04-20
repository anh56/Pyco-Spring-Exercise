package com.pyco.service;


import com.pyco.common.ErrorCode;
import com.pyco.common.GenericResponse;
import com.pyco.model.Category;
import com.pyco.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public GenericResponse getListOfCategory(){
        List<Category> categories = categoryRepo.findAll();
        if (categories != null){
            return new GenericResponse(ErrorCode.SUCCESS.getCode(), categories);
        } else return new GenericResponse(ErrorCode.NOT_FOUND_DATA.getCode(), null);
    }
}

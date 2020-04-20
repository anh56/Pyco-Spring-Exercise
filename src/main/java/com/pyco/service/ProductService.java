package com.pyco.service;


import com.pyco.common.ErrorCode;
import com.pyco.common.GenericResponse;
import com.pyco.dto.ProductDto;
import com.pyco.model.Product;
import com.pyco.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public GenericResponse getProductById(int id){
        Product product  = productRepo.findById(id);
        if (product != null) {
            return new GenericResponse(ErrorCode.SUCCESS.getCode(), product);
        } else {
            return new GenericResponse(ErrorCode.NOT_FOUND_DATA.getCode(), null);
        }
    }

    public GenericResponse getProductByName(String name) {
        Product product  = productRepo.findByName(name);
        if (product != null) {
            return new GenericResponse(ErrorCode.SUCCESS.getCode(), product);
        } else {
            return new GenericResponse(ErrorCode.NOT_FOUND_DATA.getCode(), null);
        }
    }

    public GenericResponse addProduct(ProductDto product) {
        Product currentProduct = productRepo.findById(product.getId());
        if ( currentProduct != null) {
            return new GenericResponse(ErrorCode.EXISTING_DATA.getCode(), product);
        } else {
            Product productToAdd = new Product();
            productToAdd.setId(product.getId());
            productToAdd.setCategoryId(product.getCategoryId());
            productToAdd.setName(product.getName());
            productRepo.save(productToAdd);
            return new GenericResponse(ErrorCode.CREATED.getCode(), product);
        }
    }


    public GenericResponse updateProduct(ProductDto product) {
        Product productToUpdate = productRepo.findById(product.getId());
        if (productToUpdate != null) {
            productToUpdate.setCategoryId(product.getCategoryId());
            productToUpdate.setName(product.getName());
            productRepo.save(productToUpdate);
            return new GenericResponse(ErrorCode.SUCCESS.getCode(), product);
        } else {
            return new GenericResponse(ErrorCode.NOT_FOUND_DATA.getCode(), null);
        }
    }

    public GenericResponse getAllProducts() {
        List<Product> products = productRepo.findAll();
        if (products != null) {
            return new GenericResponse(ErrorCode.SUCCESS.getCode(), products);
        } else {
            return new GenericResponse(ErrorCode.NOT_FOUND_DATA.getCode(), null);
        }
    }

    public GenericResponse deleteProductWithId(int id) {
        if (productRepo.findById(id) != null) {
            productRepo.deleteById(id);
            return new GenericResponse(ErrorCode.ACCEPTED.getCode(), null);
        }
        else{
            return new GenericResponse(ErrorCode.NOT_FOUND_DATA.getCode(),id);
        }

    }


    public GenericResponse findAllProductWithPage(int page){
        PageRequest pageable = PageRequest.of(page, 5);
        Page<Product> product = productRepo.findAll(pageable);
        if (product != null) {
            return new GenericResponse(ErrorCode.SUCCESS.getCode(), product);
        }
        else{
            return new GenericResponse(ErrorCode.NOT_FOUND_DATA.getCode(),null);
        }

    }




}

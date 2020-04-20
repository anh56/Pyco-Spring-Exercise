package com.pyco.dto;

import com.pyco.model.Product;
import lombok.Getter;
import lombok.Setter;

public class ProductDto {

    @Getter
    @Setter
    private int id;


    @Getter
    @Setter
    private int categoryId;

    @Getter
    @Setter
    private String name;


    public ProductDto(int id, int categoryId, String name) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
    }

    public ProductDto(Product product){
        this(product.getId(), product.getCategoryId(), product.getName());
    }







}

package com.pyco.model;

import com.pyco.dto.ProductDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "products")
public class Product {

    @Id
    @Setter
    @Getter
    private int id;

    @Getter
    @Setter
    private int categoryId;

    @Indexed
    @Getter
    @Setter
    private String name;


    public Product() {
    }

    public Product(int id, int categoryId, String name) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
    }

    public Product(ProductDto productDto){
        this(productDto.getId(), productDto.getCategoryId(), productDto.getName());
    }


}

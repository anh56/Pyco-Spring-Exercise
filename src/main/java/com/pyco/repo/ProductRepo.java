package com.pyco.repo;

import com.pyco.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepo extends MongoRepository<Product, Integer>, ProductRepoCustom{

    Product findById(int id);

    Product findByName(String name);

    void deleteById(int id);

    @Query("{product: {$regex: ?0}}}")
    List<Product> findCustomByRegExName(String name);



}

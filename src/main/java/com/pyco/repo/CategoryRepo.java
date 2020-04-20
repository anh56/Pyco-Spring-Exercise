package com.pyco.repo;

import com.pyco.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepo extends MongoRepository<Category, Integer>  {

}

package com.pyco.api;

import com.pyco.common.GenericResponse;
import com.pyco.dto.ProductDto;
import com.pyco.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/products")
public class ProductApi {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    @ResponseBody
    public GenericResponse getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/page")
    @ResponseBody
    public GenericResponse getProductsWithPage(@RequestParam int page){
        return productService.findAllProductWithPage(page);
    }

    @GetMapping("/id/{id}")
    @ResponseBody
    public GenericResponse getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/name/{name}")
    @ResponseBody
    public GenericResponse getProductByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    @PostMapping("/add")
    @ResponseBody
    public GenericResponse addProduct(@RequestBody ProductDto product) {
        return productService.addProduct(product);
    }

    @PutMapping("/update")
    @ResponseBody
    public GenericResponse updateProduct(@RequestBody ProductDto product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public GenericResponse deleteProductWithId(@PathVariable int id){
        return productService.deleteProductWithId(id);
    }


}

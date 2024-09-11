package com.microtech.customerApplication.controller;

import com.microtech.customerApplication.entity.Employee;
import com.microtech.customerApplication.entity.Product;
import com.microtech.customerApplication.repository.ProductRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pro")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @PostMapping("/insertpro")
    public ResponseEntity<String> insertProduct(@RequestBody Product product){
        productRepository.save(product);
        return new ResponseEntity<>("product added successfully", HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Product> getProductById(@RequestParam long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
        @GetMapping("/allprod")
                public List<Product>getAllProduct(){
            return productRepository.findAll();
        }




    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updateProduct){
        Product product=productRepository.findById(id).orElse(null);
        if(product!=null){
            product.setProdName(updateProduct.getProdName());
            product.setProdPrice(updateProduct.getProdPrice());
            product.setCountry(updateProduct.getCountry());
           productRepository.save(product);
           return ResponseEntity.ok(product);


        }else{
            return ResponseEntity.noContent().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteById(@PathVariable Long id){
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/all")
    public ResponseEntity<Product> deleteAllProduct(){
        productRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}

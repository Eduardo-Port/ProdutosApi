package io.github.Eduardo_Port.productapi.controller;

import io.github.Eduardo_Port.productapi.model.Product;
import io.github.Eduardo_Port.productapi.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        var id = UUID.randomUUID().toString();
        product.setId(id);
        productRepository.save(product);
        return product;
    }

    @GetMapping("{id}")
    public Product findProductById(@PathVariable String id) {
        return productRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable String id) {
        productRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
        product.setId(id);
        productRepository.save(product);
        return product;
    }

    @GetMapping
    public List<Product> findProductByName(@RequestParam("name") String name) {
        return productRepository.findByNameContaining(name);
    }
}

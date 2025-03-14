package io.github.Eduardo_Port.productapi.repository;

import io.github.Eduardo_Port.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByNameContaining(String name);
}

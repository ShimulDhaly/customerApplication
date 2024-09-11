package com.microtech.customerApplication.repository;

import com.microtech.customerApplication.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

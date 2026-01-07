package com.rodrigotamayoshi.dscommerce.repositories;

import com.rodrigotamayoshi.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}

package com.rodrigotamayoshi.dscommerce.services;

import com.rodrigotamayoshi.dscommerce.dto.ProductDTO;
import com.rodrigotamayoshi.dscommerce.entities.Product;
import com.rodrigotamayoshi.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    @Transactional(readOnly = true) // apenas para leitura, não "locka" o banco
    public ProductDTO findById(Long id){

        Product product =  repository.findById(id).get();
        return new ProductDTO(product);
    }

    @Transactional(readOnly = true) // apenas para leitura, não "locka" o banco
    public Page<ProductDTO> findAll(Pageable pageable){

        Page<Product> result =  repository.findAll(pageable);
        return result.map(x -> new ProductDTO(x));
    }


}

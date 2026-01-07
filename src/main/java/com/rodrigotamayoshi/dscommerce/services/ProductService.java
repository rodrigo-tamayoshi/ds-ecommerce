package com.rodrigotamayoshi.dscommerce.services;

import com.rodrigotamayoshi.dscommerce.dto.ProductDTO;
import com.rodrigotamayoshi.dscommerce.entities.Product;
import com.rodrigotamayoshi.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    @Transactional(readOnly = true) // apenas para leitura, não "locka" o banco
    public ProductDTO findById(Long id){

        Product product =  repository.findById(id).get();
        return new ProductDTO(product);
    }


}

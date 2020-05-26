package com.lxf.service;

import com.lxf.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> findAll();

    void save(Product product);
}

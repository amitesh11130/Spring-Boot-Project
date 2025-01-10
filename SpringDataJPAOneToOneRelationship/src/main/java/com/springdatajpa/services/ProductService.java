package com.springdatajpa.services;

import com.springdatajpa.entity.Product;
import com.springdatajpa.entity.Stock;
import com.springdatajpa.repository.ProductRepository;
import com.springdatajpa.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StockRepository stockRepository;

    public void saveProductWithStock(Product product , Stock stock){
        stock.setProduct(product);
        product.setStock(stock);
        productRepository.save(product);
    }


}

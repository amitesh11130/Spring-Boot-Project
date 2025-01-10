package com.springdatajpa.repository;

import com.springdatajpa.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Integer> {

}

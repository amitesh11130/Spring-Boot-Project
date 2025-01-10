package com.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "stocks")
@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stockId;
    private int stockQuantity;

    @Enumerated(EnumType.STRING)
    private StockStatus stockStatus;


    @OneToOne(mappedBy = "stock")
    private Product product;


}

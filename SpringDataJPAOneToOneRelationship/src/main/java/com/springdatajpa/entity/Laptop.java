package com.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "laptop_info")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lpId;
    private String lpType;
    private String brand;

    @OneToOne(mappedBy = "laptop",
            targetEntity = Employee.class,
            cascade = CascadeType.ALL)
    private Employee employee;
}

package com.springdatajpa.client;

import com.springdatajpa.entity.Employee;
import com.springdatajpa.entity.Laptop;
import com.springdatajpa.entity.Product;
import com.springdatajpa.entity.Stock;
import com.springdatajpa.repository.EmployeeRepository;
import com.springdatajpa.repository.LaptopRepository;
import com.springdatajpa.services.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.springdatajpa.entity.StockStatus.IN_STOCK;
import static com.springdatajpa.entity.StockStatus.OUT_OF_STOCK;

@Component
public class ClientApp implements CommandLineRunner {
    @Autowired
    private ProductService productService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LaptopRepository laptopRepository;

    @Override
    public void run(String... args) throws Exception {
        Stock s1 = Stock.builder().stockQuantity(67).stockStatus(OUT_OF_STOCK).build();
        Product p1 = Product.builder().productName("Apple Vision Pro").productPrice(320000).build();

        //  productService.saveProductWithStock(p1,s1);


        Laptop windows1 = Laptop.builder().lpType("Windows").brand("HP").build();

        Employee e1 = Employee.builder().empName("Bittu").build();
        Laptop mac1 = Laptop.builder().lpType("MAC").brand("APPLE").employee(e1).build();


//        employeeRepository.save(e1);

//        Optional<Employee> e = employeeRepository.findById(1);
//        System.out.println(e.get());

//        employeeRepository.deleteById(2);


       // mac1.setEmployee(e1);
        laptopRepository.save(mac1);

    }
}

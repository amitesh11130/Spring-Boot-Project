package com.springbootapi.test.repository;

import com.springbootapi.test.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PersonRepository extends JpaRepository<Person,Integer> {

    List<Person> findByContactIn(List<String> contact);
}

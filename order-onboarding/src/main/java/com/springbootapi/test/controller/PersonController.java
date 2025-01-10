package com.springbootapi.test.controller;

import com.springbootapi.test.entity.Person;
import com.springbootapi.test.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping(value = "/save")
    public ResponseEntity<Person> savePerson(@RequestBody Person person){
        System.out.println(person);
        return ResponseEntity.ok(personRepository.save(person));
    }

    @PostMapping(value = "/saveAll")
    public ResponseEntity<List<Person>> saveAllPerson(@RequestBody List<Person> person){
      return ResponseEntity.ok(personRepository.saveAll(person));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Person>> getAllPerson(){
        return ResponseEntity.ok(personRepository.findAll());
    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<Person>> getPersonByContact(@RequestHeader List<String> contact){
        return ResponseEntity.ok(personRepository.findByContactIn(contact));
    }

}

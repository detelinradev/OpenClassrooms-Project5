package com.openclassroom.safetynet.controller;

import com.openclassroom.safetynet.model.Person;
import com.openclassroom.safetynet.service.contracts.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping(value = "/person")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){

        return ResponseEntity.ok().body(personService.createPerson(person));
    }

    @PutMapping(value = "/person")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person){

        return  ResponseEntity.ok().body(personService.updatePerson(person));
    }

}

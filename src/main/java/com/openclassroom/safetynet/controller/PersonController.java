package com.openclassroom.safetynet.controller;

import com.openclassroom.safetynet.model.Person;
import com.openclassroom.safetynet.service.contracts.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person){

        return ResponseEntity.ok().body(personService.createPerson(person));
    }

    @PutMapping
    public ResponseEntity<Person> updatePerson(@RequestBody Person person){

        return  ResponseEntity.ok().body(personService.updatePerson(person));
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deletePerson(@RequestBody Person person){

        personService.deletePerson(person);
        return ResponseEntity.accepted().build();
    }

}

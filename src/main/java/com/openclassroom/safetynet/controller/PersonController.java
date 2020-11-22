package com.openclassroom.safetynet.controller;

import com.openclassroom.safetynet.model.Person;
import com.openclassroom.safetynet.service.contracts.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
public class PersonController {

    private final PersonService personService;

    @PostMapping(value = "/person")
    public ResponseEntity<Person> createPerson(@Valid @RequestBody Person person){

        return ResponseEntity.ok().body(personService.createPerson(person));
    }

}

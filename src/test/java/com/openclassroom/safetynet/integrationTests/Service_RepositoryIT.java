package com.openclassroom.safetynet.integrationTests;

import com.openclassroom.safetynet.model.Person;
import com.openclassroom.safetynet.repository.PersonRepositoryImpl;
import com.openclassroom.safetynet.repository.contracts.PersonRepository;
import com.openclassroom.safetynet.service.PersonServiceImpl;
import com.openclassroom.safetynet.service.contracts.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {PersonServiceImpl.class, PersonRepositoryImpl.class})
public class Service_RepositoryIT {

    @Autowired
    PersonService personService;

    @Autowired
    PersonRepository personRepository;

    private Person person;

    @BeforeEach
    private void setUp() {
        person = new Person();
    }

    @Test
    public void createPerson_Should_CreatePerson(){

        //act
        Person newPerson = personService.createPerson(person);

        //assert
        Assertions.assertEquals(person,newPerson);
    }

}

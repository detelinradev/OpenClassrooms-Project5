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

import java.io.IOException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {PersonServiceImpl.class, PersonRepositoryImpl.class})
public class Service_RepositoryIT {

    @Autowired
    PersonService personService;

    @Autowired
    PersonRepository personRepository;

    private Person person;

    @BeforeEach
    private void setUp() throws IOException {
        person = new Person();
        person.setFirstName("Ivan");
        person.setLastName("Nikolov");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("zip");
        person.setPhone("phone");
        person.setEmail("email");
        personRepository.readData();
    }

    @Test
    public void createPerson_Should_CreatePerson(){

        //act
        Person newPerson = personService.createPerson(person);

        //assert
        Assertions.assertEquals(person,newPerson);
    }

    @Test
    public void updatePerson_Should_updatePerson(){

        //act
        Person newPerson =  personService.updatePerson(person);

        //assert
        Assertions.assertEquals(person,newPerson);
    }

}

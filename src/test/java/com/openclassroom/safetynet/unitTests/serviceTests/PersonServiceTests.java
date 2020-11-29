package com.openclassroom.safetynet.unitTests.serviceTests;

import com.openclassroom.safetynet.model.Person;
import com.openclassroom.safetynet.repository.contracts.PersonRepository;
import com.openclassroom.safetynet.service.PersonServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTests {

    @Mock
    PersonRepository personRepository;

    @InjectMocks
    PersonServiceImpl personService;

    private Person person;

    @BeforeEach
    private void setUp(){
        person = new Person();
    }

    @Test
    public void createPerson_Should_CreatePerson(){

        //arrange
        when(personRepository.createPerson(person)).thenReturn(person);

        //act & assert
        Assertions.assertEquals(person, personService.createPerson(person));
    }

}

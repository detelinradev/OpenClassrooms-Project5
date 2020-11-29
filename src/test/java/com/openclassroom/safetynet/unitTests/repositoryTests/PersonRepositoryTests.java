package com.openclassroom.safetynet.unitTests.repositoryTests;

import com.openclassroom.safetynet.model.Person;
import com.openclassroom.safetynet.repository.PersonRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class PersonRepositoryTests {

    @Spy
    PersonRepositoryImpl personRepository;

    private Person person;
    private Person updatedPerson;
    private Map<String, List<Map<String, String>>> database;
    private List<Map<String, String>> list;

    @BeforeEach
    private void setUp() {
        person = new Person("Cron", "Boyd", "1000 Monroe St", "Boston", "15000",
                "123-444-555", "cronboyd@email.com");
        updatedPerson = new Person("Michael", "Long", "1000 Monroe St", "Boston", "15000",
                "123-444-555", "cronboyd@email.com");
        database = new HashMap<>();
        list = new ArrayList<>();
        database.put("persons", list);

    }

    @Test
    public void createPerson_Should_CreatePerson() {

        //arrange
        doReturn(database).when(personRepository).getDatabase();

        //act
        Person newPerson = personRepository.createPerson(person);

        //assert
        Assertions.assertEquals(person, newPerson);
        Assertions.assertNotNull(database.get("persons"));
    }

    @Test
    public void updatePerson_Should_updatePerson(){

        //arrange
        createPerson_Should_CreatePerson();
        doReturn(database).when(personRepository).getDatabase();

        //act
        Person newPerson = personRepository.updatePerson(updatedPerson);

        //assert
        Assertions.assertEquals(updatedPerson,newPerson);
    }
}

package com.openclassroom.safetynet.repositoryTests;

import com.openclassroom.safetynet.model.Person;
import com.openclassroom.safetynet.repository.PersonRepositoryImpl;
import com.openclassroom.safetynet.repository.contracts.PersonRepository;
import com.openclassroom.safetynet.service.PersonServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
    private Map<String, List<Map<String, String>>> database;
    private List<Map<String, String>> list;

    @BeforeEach
    private void setUp() {
        person = new Person("Cron", "Boyd", "1000 Monroe St", "Boston", "15000",
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
}

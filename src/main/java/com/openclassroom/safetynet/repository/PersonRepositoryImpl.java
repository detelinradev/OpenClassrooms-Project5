package com.openclassroom.safetynet.repository;

import com.openclassroom.safetynet.model.Person;
import com.openclassroom.safetynet.repository.contracts.PersonRepository;
import org.springframework.stereotype.Component;

@Component
public class PersonRepositoryImpl implements PersonRepository {

    @Override
    public Person createPerson(Person person) {
        return person;
    }
}

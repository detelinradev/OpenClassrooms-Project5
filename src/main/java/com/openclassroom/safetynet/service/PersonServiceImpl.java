package com.openclassroom.safetynet.service;

import com.openclassroom.safetynet.model.Person;
import com.openclassroom.safetynet.service.contracts.PersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public Person createPerson(Person person) {
        return person;
    }
}

package com.openclassroom.safetynet.service;

import com.openclassroom.safetynet.model.Person;
import com.openclassroom.safetynet.repository.contracts.PersonRepository;
import com.openclassroom.safetynet.service.contracts.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Person createPerson(Person person) {
        return personRepository.createPerson(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return null;
    }
}

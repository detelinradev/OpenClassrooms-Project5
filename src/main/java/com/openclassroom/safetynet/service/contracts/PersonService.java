package com.openclassroom.safetynet.service.contracts;

import com.openclassroom.safetynet.model.Person;

public interface PersonService {

    Person createPerson(Person person);

    Person updatePerson(Person person);

    void deletePerson(Person person);
}

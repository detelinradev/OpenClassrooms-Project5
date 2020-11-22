package com.openclassroom.safetynet.repository.contracts;

import com.openclassroom.safetynet.model.Person;

public interface PersonRepository {

    Person createPerson(Person person);
}

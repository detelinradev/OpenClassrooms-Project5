package com.openclassroom.safetynet.repository.contracts;

import com.openclassroom.safetynet.model.Person;

import java.io.IOException;

public interface PersonRepository {

    Person createPerson(Person person);

    void readData() throws IOException;
}

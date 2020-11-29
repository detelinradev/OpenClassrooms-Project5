package com.openclassroom.safetynet.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassroom.safetynet.model.Person;
import com.openclassroom.safetynet.repository.contracts.PersonRepository;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PersonRepositoryImpl implements PersonRepository {

    private Map<String, List<Map<String,String>>> database;

    @SuppressWarnings("unchecked")
    @Override
    public void readData() throws IOException {
        try(Reader reader = new FileReader("dataBase.txt")){
            database = new ObjectMapper().readValue(reader, HashMap.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(String key: database.keySet()){
            System.out.println(key + " : " + database.get(key));
        }
    }

    @Override
    public Person createPerson(Person person) {
        Map<String,String>newPerson = new HashMap<>();
        newPerson.put("firstName", person.getFirstName());
        newPerson.put("lastName", person.getLastName());
        newPerson.put("address", person.getAddress());
        newPerson.put("city", person.getCity());
        newPerson.put("zip", person.getZip());
        newPerson.put("phone", person.getPhone());
        newPerson.put("email", person.getEmail());
        database.get("persons").add(newPerson);
        return person;
    }
}

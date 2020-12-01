package com.openclassroom.safetynet.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassroom.safetynet.model.Person;
import com.openclassroom.safetynet.repository.contracts.PersonRepository;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Data
public class PersonRepositoryImpl implements PersonRepository {

    private Map<String, List<Map<String, String>>> database;

    @SuppressWarnings("unchecked")
    @Override
    public void readData() throws IOException {
        try (Reader reader = new FileReader("dataBase.txt")) {
            setDatabase(new ObjectMapper().readValue(reader, HashMap.class));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (String key : database.keySet()) {
            System.out.println(key + " : " + database.get(key));
        }
    }

    @Override
    public Person updatePerson(Person person) {
        Map<String, String> updatedPerson = createMapFromPerson(person);
        List<Map<String, String>> newList = getDatabase().get("persons");
        int count = 0;
        for (int i = 0; i < newList.size(); i++) {
            if (newList.get(i).get("firstName").equals(person.getFirstName()) &&
                    newList.get(i).get("lastName").equals(person.getLastName())) {
                count = i;
            }
        }
        newList.set(count,updatedPerson);
        getDatabase().put("persons", newList);
        return person;
    }

    @Override
    public void deletePerson(Person person) {

    }

    @Override
    public Person createPerson(Person person) {
        Map<String, String> newPerson = createMapFromPerson(person);
        getDatabase().get("persons").add(newPerson);
        return person;
    }

    private Map<String, String> createMapFromPerson(Person person) {
        Map<String, String> newPerson = new HashMap<>();
        newPerson.put("firstName", person.getFirstName());
        newPerson.put("lastName", person.getLastName());
        newPerson.put("address", person.getAddress());
        newPerson.put("city", person.getCity());
        newPerson.put("zip", person.getZip());
        newPerson.put("phone", person.getPhone());
        newPerson.put("email", person.getEmail());
        return newPerson;
    }
}

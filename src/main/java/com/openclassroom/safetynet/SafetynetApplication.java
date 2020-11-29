package com.openclassroom.safetynet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.openclassroom.safetynet.repository.PersonRepositoryImpl;
import com.openclassroom.safetynet.repository.contracts.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SafetynetApplication {

    public static void main(String[] args) {

        SpringApplication.run(SafetynetApplication.class, args);
        PersonRepository repository = new PersonRepositoryImpl();
        try{
            repository.readData();
        }catch (JsonProcessingException e){
            System.out.println("Database file not available");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

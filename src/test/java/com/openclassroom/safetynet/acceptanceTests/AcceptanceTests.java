package com.openclassroom.safetynet.acceptanceTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassroom.safetynet.controller.PersonController;
import com.openclassroom.safetynet.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AcceptanceTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonController personController;

    private Person person;
    private JacksonTester<Person> jsonPerson;

    @BeforeEach
    public void setUp() {
        person = new Person("Cron", "Boyd", "1000 Monroe St", "Boston", "15000",
                "123-444-555", "cronboyd@email.com");
        JacksonTester.initFields(this, new ObjectMapper());
//        mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
    }

    @Test
    public void passingPersonToEndpointPersonWithPostMethod_Should_createNewPerson_When_conditionsAreMet() throws Exception {

        //when
        MockHttpServletResponse response = mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPerson.write(person).getJson())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        //then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonPerson.write(person).getJson());
    }
}

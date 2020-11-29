package com.openclassroom.safetynet.integrationTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassroom.safetynet.controller.PersonController;
import com.openclassroom.safetynet.model.Person;
import com.openclassroom.safetynet.repository.contracts.PersonRepository;
import com.openclassroom.safetynet.service.PersonServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {PersonServiceImpl.class, PersonController.class})
@WebMvcTest
public class Controller_ServiceIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonRepository personRepository;

    private JacksonTester<Person> jacksonTester;
    private Person person;

    @BeforeEach
    private void setUp(){

        person = new Person();
        JacksonTester.initFields(this,new ObjectMapper());
    }

    @Test
    public void createPerson_Should_returnPerson() throws Exception {

        //given
        given(personRepository.createPerson(person)).willReturn(person);

        //when
        MockHttpServletResponse response = mockMvc.perform(
                post("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jacksonTester.write(person).getJson())
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        //then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(jacksonTester.write(person).getJson());

    }

    @Test
    public void updatePerson_Should_updatePerson() throws Exception{

        //given
        given(personRepository.updatePerson(person)).willReturn(person);

        //when
        MockHttpServletResponse response = mockMvc.perform(
                put("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jacksonTester.write(person).getJson())
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        //then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(jacksonTester.write(person).getJson());
    }

}

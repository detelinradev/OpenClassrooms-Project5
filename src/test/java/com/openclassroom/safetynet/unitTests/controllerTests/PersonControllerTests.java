package com.openclassroom.safetynet.unitTests.controllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassroom.safetynet.controller.PersonController;
import com.openclassroom.safetynet.model.Person;
import com.openclassroom.safetynet.service.PersonServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(MockitoExtension.class)
public class PersonControllerTests {

    private MockMvc mockMvc;

    @Mock
    PersonServiceImpl personService;

    @InjectMocks
    PersonController personController;

    private JacksonTester<Person> jsonPerson;
    private Person person;

    @BeforeEach
    private void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
        mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
        person = new Person();
    }

    @Test
    public void createPerson_Should_createPerson_When_dataIsValid() throws Exception {

        //given
        given(personService.createPerson(person)).willReturn(person);

        //when
        MockHttpServletResponse response = mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPerson.write(person).getJson())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        //then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonPerson.write(person).getJson());
    }

    @Test
    public void updatePerson_Should_updatePerson_When_dataIsValid() throws Exception{

        //given
        given(personService.updatePerson(person)).willReturn(person);

        //when
        MockHttpServletResponse response = mockMvc.perform(
                put("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPerson.write(person).getJson())
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        //then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonPerson.write(person).getJson());
    }

    @Test
    public void deletePerson_Should_deletePerson_When_dataIsValid() throws Exception {

        //given
        doNothing().when(personService).deletePerson(person);

        //when
        MockHttpServletResponse response = mockMvc.perform(
                delete("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPerson.write(person).getJson()))
                .andReturn().getResponse();

        //then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.ACCEPTED.value());
    }

}

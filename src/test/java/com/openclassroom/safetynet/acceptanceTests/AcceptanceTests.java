package com.openclassroom.safetynet.acceptanceTests;

import com.openclassroom.safetynet.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(MockitoExtension.class)
public class AcceptanceTests {

    private MockMvc mockMvc;
    private Person person = new Person("Cron","Boyd","1000 Monroe St","Boston","15000","123-444-555","cronboyd@email.com");
    private JacksonTester<Person> jsonPerson;

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

package com.openclassroom.safetynet.unitTests.modelTests;

import com.openclassroom.safetynet.model.Person;
import org.junit.jupiter.api.*;

@Tag("PersonTests")
@DisplayName("Unit tests for Person class")
public class PersonTests {

    private Person person;

    @BeforeEach
    private void setUp() {
        person = new Person("Cron", "Boyd", "1000 Monroe St",
                "Boston", "15000", "123-444-555", "cronboyd@email.com");
    }

    @Test
    public void getFirstName_Should_returnFirstName() {

        //act
        String firstName = person.getFirstName();

        //assert
        Assertions.assertEquals("Cron", firstName);
    }

    @Test
    public void setFirstName_should_setFirstName(){

        //act
        person.setFirstName("Michael");

        //assert
        Assertions.assertEquals("Michael",person.getFirstName());
    }

    @Test
    public void getLastName_Should_ReturnLastName(){

        //act
        String lastName = person.getLastName();

        //assert
        Assertions.assertEquals("Boyd",lastName);
    }

    @Test
    public void setLastName_Should_SetLastName(){

        //act
        person.setLastName("John");

        //assert
        Assertions.assertEquals("John",person.getLastName());
    }

    @Test
    public void getAddress_Should_returnAddress(){

        //act
        String address = person.getAddress();

        //assert
        Assertions.assertEquals("1000 Monroe St", address);
    }

    @Test
    public void setAddress_Should_returnAddress(){

        //act
        person.setAddress("101 Hillery St");

        //assert
        Assertions.assertEquals("101 Hillery St", person.getAddress());
    }

    @Test
    public void getCity_Should_returnCity(){

        //act
        String city = person.getCity();

        //assert
        Assertions.assertEquals("Boston", city);
    }

    @Test
    public void setCity_Should_setCity(){

        //act
        person.setCity("New York");

        //assert
        Assertions.assertEquals("New York", person.getCity());
    }

    @Test
    public void getZip_Should_returnZip(){

        //act
        String zip = person.getZip();

        //assert
        Assertions.assertEquals("15000", zip);
    }

    @Test
    public void setZip_Should_setZip(){

        //act
        person.setZip("10000");

        //assert
        Assertions.assertEquals("10000", person.getZip());
    }

    @Test
    public void getPhone_Should_returnPhone(){

        //act
        String phone = person.getPhone();

        //assert
        Assertions.assertEquals("123-444-555",phone);
    }

    @Test
    public void setPhone_Should_setPhone(){

        //act
        person.setPhone("111-222-3333");

        //assert
        Assertions.assertEquals("111-222-3333",person.getPhone());
    }

    @Test
    public void getEmail_Should_returnEmail(){

        //act
        String email = person.getEmail();

        //assert
        Assertions.assertEquals("cronboyd@email.com", email);
    }

    @Test
    public void setEmail_should_setEmail(){

        //act
        person.setEmail("john@email.com");

        //assert
        Assertions.assertEquals("john@email.com", person.getEmail());
    }

    @Test
    public void createPersonWithoutParameters_Should_CreatePerson(){

        //act
        Person newPerson = new Person();

        //assert
        Assertions.assertNotNull(newPerson);
    }

}

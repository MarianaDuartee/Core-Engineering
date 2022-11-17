package org.marianaduarte.tema12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
public class PersonBuilderTest {

    private PersonBuilder personBuilder;

    @BeforeEach
    public void setUp(){
        personBuilder = new PersonBuilder();
    }

    @Test
    public void personWithName(){
       String name = "Mariana";
       Person person = personBuilder.builder().withName(name).build();
       assertEquals(name, person.getName());
    }

    @Test
    public void personWithBirthDate(){
        LocalDate birthDate = LocalDate.of(2001,03,20);
        Person person = personBuilder.builder().withBirthDate(birthDate).build();
        assertEquals(birthDate,person.getBirthDate());
    }

    @Test
    public void personWithAddres(){
        Address address = new Address();
        address.setStreet("Avenida Campos Eliseos");
        address.setNumber(882);
        address.setCity("Araujos");
        address.setState("Minas Gerais");
        Person person = personBuilder.builder().withAddress(address.getStreet(),address.getNumber(),address.getCity(),address.getState()).build();
        assertEquals(address.toString(), person.getAddress().toString());
    }

}

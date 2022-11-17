package org.marianaduarte.tema12;

import java.time.LocalDate;

public class PersonBuilderDemo {
    public static void main(String[] args) {
        Person completePerson = PersonBuilder.builder()
                .withName("Mariana")
                .withBirthDate(LocalDate.of(2001,03,20))
                .withAddress("Av.Campos Eliseos",882,"Araujos","Minas Gerais")
                .build();
        System.out.println(completePerson.toString());
    }
}

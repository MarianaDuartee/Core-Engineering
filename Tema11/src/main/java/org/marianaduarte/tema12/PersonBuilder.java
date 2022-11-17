package org.marianaduarte.tema12;

import java.time.LocalDate;

public class PersonBuilder {
    private Person person;

    public PersonBuilder(){
        this.person = new Person();
    }

    public static PersonBuilder builder(){
        return new PersonBuilder();
    }

    public PersonBuilder withName(String name){
        this.person.setName(name);
        return this;
    }
    public PersonBuilder withBirthDate(LocalDate birthDate){
        this.person.setBirthDate(birthDate);
        return this;
    }
    public PersonBuilder withAddress(String street, Integer number, String city, String state){
        Address address = new Address();
        address.setStreet(street);
        address.setNumber(number);
        address.setCity(city);
        address.setState(state);
        this.person.setAddress(address);
        return this;
    }

    public Person build(){
        return this.person;
    }
}

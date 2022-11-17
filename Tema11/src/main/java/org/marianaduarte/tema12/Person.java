package org.marianaduarte.tema12;

import java.time.LocalDate;

public class Person {
    private String name;
    private LocalDate birthDate;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String toString() {
        return this.name+" | "+this.birthDate+"\n"+this.address.toString();
    }
}

package by.gourianova.binocularvision.entity;

import java.math.BigInteger;
import java.util.Objects;

abstract class Person {
    public Person() {
    }

   /* public enum PersonsType {
        USER,
        ADMINISTRATOR,
        CUSTOMER
    }*/
    protected BigInteger id;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }


    public Person(BigInteger id) {this.id = id;    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person appliance = (Person) o;
        return id == appliance.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


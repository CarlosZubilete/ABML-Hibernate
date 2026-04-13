package entity;

import jakarta.persistence.*;
import types.GenderType;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "persons")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true , nullable = false)
    private String dni ;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private GenderType gender;

    private LocalDate birthday;
    private String address;

    public Person(){}

    public Person(String dni, String firstName, String lastName, GenderType gender, LocalDate birthday, String address) {
        this.dni = dni;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(dni, person.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }

    @Override
    public String toString() {
        return " Person { " +
            " id = " + id +
            ", dni = '" + dni + '\'' +
            ", firstName = '" + firstName + '\'' +
            ", lastName = '" + lastName + '\'' +
            ", gender = " + gender +
            ", birthday = " + birthday +
            ", address = '" + address + '\'' +
            '}';
    }
}



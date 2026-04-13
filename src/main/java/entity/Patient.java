package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import types.GenderType;

import java.time.LocalDate;

@Entity
@Table(name = "patients")
@PrimaryKeyJoinColumn(name = "id")
public class Patient extends Person{

    public Patient (){}

    public Patient(String dni, String firstName, String lastName, GenderType gender, LocalDate birthday, String address) {
        super(dni, firstName, lastName, gender, birthday, address);
    }


}

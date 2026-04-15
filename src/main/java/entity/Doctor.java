package entity;

import jakarta.persistence.*;
import types.GenderType;

import java.time.LocalDate;

@Entity
@Table(name = "doctors")
@PrimaryKeyJoinColumn(name = "id")
public class Doctor extends Person{

    @Column(unique = true)
    private String employeeId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_specialization")
    private Specialization specialization;

    public Doctor(){}

    public Doctor(String dni, String firstName, String lastName, GenderType gender, LocalDate birthday, String address, String employeeId) {
        super(dni, firstName, lastName, gender, birthday, address);
        this.employeeId = employeeId;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specializationType) {
        this.specialization = specializationType;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return " Doctor { " +
            " employeeId = '" + employeeId + '\'' +
            '}' + " " + specialization.getSpecialization() + " "
            + super.getFirstName() +  " " + super.getLastName() + " " + super.getDni();
    }
}

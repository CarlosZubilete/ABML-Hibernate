package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import types.GenderType;

import java.time.LocalDate;

@Entity
@Table(name = "doctors")
@PrimaryKeyJoinColumn(name = "id")
public class Doctor extends Person{

    @Column(unique = true)
    private String employeeId;

    public Doctor(String dni, String firstName, String lastName, GenderType gender, LocalDate birthday, String address, String employeeId) {
        super(dni, firstName, lastName, gender, birthday, address);
        this.employeeId = employeeId;
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
            '}';
    }
}

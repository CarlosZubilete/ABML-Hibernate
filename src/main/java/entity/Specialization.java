package entity;

import jakarta.persistence.*;
import types.SpecializationType;

import java.util.Objects;

@Entity
@Table(name = "specializations")
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private SpecializationType specialization;

    public Specialization(){}

    public Specialization(SpecializationType specialization) {
        this.specialization = specialization;
    }

    public SpecializationType getSpecialization() {
        return specialization;
    }

    public void setSpecialization(SpecializationType specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return " Specialization { " +
            " id = " + id +
            ", specialization = " + specialization +
            '}';
    }
}

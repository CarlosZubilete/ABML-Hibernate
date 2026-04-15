package entity;

import jakarta.persistence.*;
import types.StateType;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private Date dateAppointment;
    private float schedule;
    private String observation;
    @Enumerated(EnumType.STRING)
    private StateType state;

    public Appointment(){}

    public Appointment(Doctor doctor, Patient patient, Date dateAppointment, float schedule, String observation, StateType state) {
        this.doctor = doctor;
        this.patient = patient;
        this.dateAppointment = dateAppointment;
        this.schedule = schedule;
        this.observation = observation;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDateAppointment() {
        return dateAppointment;
    }

    public void setDateAppointment(Date dateAppointment) {
        this.dateAppointment = dateAppointment;
    }

    public float getSchedule() {
        return schedule;
    }

    public void setSchedule(float schedule) {
        this.schedule = schedule;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public StateType getState() {
        return state;
    }

    public void setState(StateType state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Float.compare(schedule, that.schedule) == 0 && Objects.equals(doctor, that.doctor) && Objects.equals(patient, that.patient) && Objects.equals(dateAppointment, that.dateAppointment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctor, patient, dateAppointment, schedule);
    }

    @Override
    public String toString() {
        return " Appointment { " +
            " doctor = " + doctor +
            ", patient = " + patient +
            ", dateAppointment = " + dateAppointment +
            ", schedule = " + schedule +
            ", observation = '" + observation + '\'' +
            ", state = " + state +
            '}';
    }
}




















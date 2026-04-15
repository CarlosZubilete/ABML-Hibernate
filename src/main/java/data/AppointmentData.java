package data;

import entity.Appointment;
import entity.Doctor;
import entity.Patient;
import service.AppointmentService;
import service.DoctorService;
import service.PatientService;
import types.StateType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppointmentData {

    public static List<Appointment> loadAppointments() {

        DoctorService doctorService = new DoctorService();
        PatientService patientService = new PatientService();

        List<Doctor> doctors = doctorService.findAll();
        List<Patient> patients = patientService.findAll();

        List<Appointment> appointments = new ArrayList<>();

        // Doctor 1 (Sofia Lucieri)
        appointments.add(new Appointment(
            doctors.get(0),
            patients.get(0),
            new Date(),
            9.0f,
            "Control general",
            StateType.PENDING
        ));

        appointments.add(new Appointment(
            doctors.get(0),
            patients.get(1),
            new Date(),
            10.0f,
            "Dolor abdominal",
            StateType.PENDING
        ));

        appointments.add(new Appointment(
            doctors.get(0),
            patients.get(2),
            new Date(),
            11.0f,
            "Chequeo anual",
            StateType.COMPLETED
        ));

        // Doctor 2 (Claudio Fernandez)
        appointments.add(new Appointment(
            doctors.get(1),
            patients.get(3),
            new Date(),
            9.5f,
            "Dolor de pecho",
            StateType.PENDING
        ));

        appointments.add(new Appointment(
            doctors.get(1),
            patients.get(4),
            new Date(),
            10.5f,
            "Control cardiológico",
            StateType.PENDING
        ));

        appointments.add(new Appointment(
            doctors.get(1),
            patients.get(5),
            new Date(),
            11.5f,
            "Seguimiento presión",
            StateType.COMPLETED
        ));

        // Doctor 3 (Elena Russo)
        appointments.add(new Appointment(
            doctors.get(2),
            patients.get(6),
            new Date(),
            8.0f,
            "Dolor de rodilla",
            StateType.PENDING
        ));

        appointments.add(new Appointment(
            doctors.get(2),
            patients.get(7),
            new Date(),
            9.0f,
            "Lesión deportiva",
            StateType.ABSENT
        ));

        appointments.add(new Appointment(
            doctors.get(2),
            patients.get(8),
            new Date(),
            10.0f,
            "Control post-operatorio",
            StateType.PENDING
        ));

        appointments.add(new Appointment(
            doctors.get(2),
            patients.get(9),
            new Date(),
            11.0f,
            "Fractura brazo",
            StateType.COMPLETED
        ));

//        AppointmentService appointmentService = new AppointmentService();
//
//
//        for ( Appointment appointment : appointments){
//            appointmentService.save(appointment);
//        }


        return appointments;
    }
}

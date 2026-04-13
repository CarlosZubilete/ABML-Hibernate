package data;

import entity.Doctor;
import entity.Patient;
import service.DoctorService;
import service.PatientService;

import java.util.List;

public class HandleData {


    public static void addDoctors(){

        DoctorService service = new DoctorService();
        List<Doctor> doctors =  DoctorData.getInitialDoctors();

        int count = 1;
        for (Doctor doctor : doctors){
            service.save(doctor);
            System.out.println(count + " doctor save ...");
            count++;
        }
    }

    public static void addPatients(){

        List<Patient> patients = PatientData.getInitialPatients();
        PatientService service = new PatientService();

        int coun = 1 ;
        for (Patient patient : patients){
            service.save(patient);
            System.out.println(coun + " Patient save ...");
            coun++;
        }
    }



}

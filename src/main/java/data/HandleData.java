package data;

import entity.Doctor;
import entity.Patient;
import entity.Specialization;
import entity.User;
import service.DoctorService;
import service.PatientService;
import service.SpecializationService;
import service.UserService;

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

        int count = 1 ;
        for (Patient patient : patients){
            service.save(patient);
            System.out.println(count + " Patient save ...");
            count++;
        }
    }

    public static void addUsers(){
        List<User> users = UserData.getInitialUsers();
        UserService service = new UserService();
        int count = 1;
        for (User user: users){
            service.save(user);
            System.out.println(count + " User save ...");
            count++;
        }

    }

    public static void addSpecializations(){
        List<Specialization> specializations = SpecializationData.getInitialSpecializations();
        SpecializationService service = new SpecializationService();

        int count = 1;
        for (Specialization specialization : specializations) {
            service.save(specialization);
            System.out.println(count + "Specialization save ...");
            count++;
        }
    }

    // UPDATE DATA
    public static void updateDoctorWhitSpecialization(){
        SpecializationService specializationService = new SpecializationService();
        List<Specialization> specializations = specializationService.findAll();

        DoctorService doctorService = new DoctorService();
        List<Doctor> doctors = doctorService.findAll();

        for ( int i = 0 ; i < doctors.size() ; i++){
            Doctor d = doctors.get(i);
            d.setSpecialization(specializations.get(i));
            doctorService.update(d);

        }
        /*
        int count = 0;
        for ( Doctor doctor : doctors) {
            doctor.setSpecialization(specializations);
        }

        Specialization pediatra = specializationService.findById(1L);

        Doctor sofiaDoctor = doctorService.findByDni("20.345.678");

        sofiaDoctor.setSpecialization(pediatra);
        */

    }




}

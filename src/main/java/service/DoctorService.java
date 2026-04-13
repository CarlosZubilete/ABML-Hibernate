package service;

import entity.Doctor;
import repository.Repository;

public class DoctorService extends GenericService<Doctor>{

    public DoctorService(){
         super(new Repository<>(Doctor.class));
    }

    // Here we can write queries specific .
    // findBySpeciality for example
}

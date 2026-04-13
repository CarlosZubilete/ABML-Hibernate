package service;

import entity.Patient;
import repository.Repository;

public class PatientService extends GenericService<Patient>{

    public PatientService(){
        super(new Repository<>(Patient.class));
    }
}

/*
    public PatientService(Repository<Patient> repository) {
        super(repository);
    }
* */

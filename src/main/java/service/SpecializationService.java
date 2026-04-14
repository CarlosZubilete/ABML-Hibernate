package service;

import entity.Specialization;
import repository.Repository;

public class SpecializationService extends GenericService<Specialization>{

    public SpecializationService(){
        super(new Repository<>(Specialization.class));
    }

}

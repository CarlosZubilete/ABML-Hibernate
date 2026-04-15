package service;

import entity.Appointment;
import repository.Repository;

public class AppointmentService extends GenericService<Appointment>{

    public AppointmentService(){
        super(new Repository<>(Appointment.class));
    }

}










package service;

import config.HibernateUtil;
import entity.Doctor;
import entity.Specialization;
import org.hibernate.Session;
import repository.DoctorRepository;
import repository.Repository;
import types.SpecializationType;

import java.util.List;

public class DoctorService extends GenericService<Doctor>{


    private final DoctorRepository repository = new DoctorRepository();

    public DoctorService(){
         super(new Repository<>(Doctor.class));
    }

    public Doctor findByDni(String dni){
        Doctor doctor = null;
        try(Session session = HibernateUtil.openSession()){
            doctor = repository.findByDNI(session, dni);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctor;
    }

    public List<Doctor> findBySpeciality(SpecializationType specialization){
        List<Doctor> doctors = null;
        try (Session session = HibernateUtil.openSession()){
            doctors = repository.findBySpeciality( session, specialization);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctors;
    }


}

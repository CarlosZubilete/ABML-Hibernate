package repository;

import entity.Doctor;
import org.hibernate.Session;
import types.SpecializationType;

import java.util.List;

public class DoctorRepository extends Repository<Doctor>{

    public DoctorRepository(){
        super(Doctor.class);
    }

    public Doctor findByDNI(Session session,  String dni){
        return session
            .createQuery("FROM Doctor doc WHERE doc.dni = :dni", Doctor.class)
            .setParameter("dni", dni)
            .uniqueResult();
    }

    public List<Doctor> findBySpeciality(Session session, SpecializationType specialization) {
        return session
            // .createQuery("FROM Doctor doc WHERE doc.nameClassComposition.nameClass = :specialization", Doctor.class)
            .createQuery("FROM Doctor doc WHERE doc.specializationType.specialization = :specialization", Doctor.class)
            .setParameter("specialization", specialization)
            .list();
    }
}

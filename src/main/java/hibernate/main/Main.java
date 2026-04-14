package hibernate.main;


import config.HibernateUtil;
import data.HandleData;
import entity.Doctor;
import service.DoctorService;
import types.SpecializationType;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        HandleData.addDoctors();
//
//        HandleData.addPatients();
//
//        HandleData.addUsers();
//
//        HandleData.addSpecializations();
//
//        HandleData.updateDoctorWhitSpecialization();

        DoctorService doctorService = new DoctorService();
        List<Doctor> doctorList = doctorService.findBySpeciality(SpecializationType.PEDIATRIA);

        for ( Doctor doc : doctorList) {
            System.out.println(doc.toString());
        }

        HibernateUtil.shutdown();
    }
}
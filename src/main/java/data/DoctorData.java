package data;

import entity.Doctor;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import types.GenderType;

public class DoctorData {

    // private Gender gender;

    public static List<Doctor> getInitialDoctors(){

        List<Doctor> doctors = new ArrayList<>();

        // 1.
        doctors.add(new Doctor("20.345.678", "Sofia", "Lucieri",
            GenderType.FEMININE ,  LocalDate.of(1985, 5, 20), "Av. Cazon 123",
                "11-111-11"));
        //2.
        doctors.add(new Doctor("25.123.456", "Claudio", "Fernandez",
            GenderType.MASCULINE, LocalDate.of(1890,5,14),"Av. Yrigoyen 222",
            "22-222-22"));
        //3.
        doctors.add(new Doctor("28.334.221", "Elena", "Russo",
            GenderType.FEMININE, LocalDate.of(1992, 3, 8),
            "Paseo Victorica 789", "33-333-33"));

        return  doctors;
    }
}

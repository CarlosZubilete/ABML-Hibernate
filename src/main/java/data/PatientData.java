package data;

import entity.Patient;
import types.GenderType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class PatientData {

    public static List<Patient> getInitialPatients(){
        List<Patient> patients = new ArrayList<>();

        // 1.
        patients.add(new Patient("18.999.456", "Matias", "Dirube", GenderType.MASCULINE ,
            LocalDate.of(1975,12,10),"Av. Mapipu 444"));
        // 2.
        patients.add(new Patient("30.456.789", "Tamara","Herrera", GenderType.FEMININE ,
            LocalDate.of(1990,1,30), "Av. Constitucion 934"));
        // 3.
        patients.add(new Patient("28.777.888", "Elena", "Gomez", GenderType.FEMININE,
            LocalDate.of(1989,9,25), "Constituyentes 454"));

        //4.
        patients.add(new Patient("24.778.552", "Julián", "Sánchez",
            GenderType.MASCULINE, LocalDate.of(1980, 7, 25),
            "Av. Libertador 2010"));
        //5.
        patients.add(new Patient("30.112.900", "Sofía", "Martínez",
            GenderType.FEMININE, LocalDate.of(1988, 12, 30),
            "Belgrano 550"));
        //6.
        patients.add(new Patient("21.445.678", "Ricardo", "López",
            GenderType.MASCULINE, LocalDate.of(1975, 1, 15),
            "Constitución 300"));
        //7.
        patients.add(new Patient("33.876.123", "Valeria", "Paz",
            GenderType.FEMININE, LocalDate.of(1995, 9, 5),
            "Alvear 1200"));
        //8.
        patients.add(new Patient("26.543.987", "Andrés", "Castro",
            GenderType.MASCULINE, LocalDate.of(1983, 6, 18),
            "Las Heras 45" ));
        //9.
        patients.add(new Patient("29.998.234", "Mariana", "Ortega",
            GenderType.FEMININE, LocalDate.of(1990, 4, 22),
            "Sarmiento 900"));
        //10.
        patients.add(new Patient("27.654.321", "Esteban", "Ríos",
            GenderType.MASCULINE, LocalDate.of(1987, 8, 10),
            "Boulevard de Todos los Santos 100"));

        return  patients;
    }
}

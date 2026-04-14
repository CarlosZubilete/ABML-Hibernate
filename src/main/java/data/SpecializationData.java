package data;

import entity.Specialization;
import types.SpecializationType;

import java.util.ArrayList;
import java.util.List;

public class SpecializationData {

    public static List<Specialization> getInitialSpecializations(){
        List<Specialization> specializations = new ArrayList<>();

        specializations.add(new Specialization(SpecializationType.PEDIATRIA));
        specializations.add(new Specialization(SpecializationType.CARDIOLOGIA));
        specializations.add(new Specialization(SpecializationType.TRAUMATOLODIA));

        return specializations;
    }
}

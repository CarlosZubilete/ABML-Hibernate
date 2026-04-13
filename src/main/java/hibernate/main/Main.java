package hibernate.main;


import config.HibernateUtil;
import data.HandleData;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        HandleData.addDoctors();

        HandleData.addPatients();

        HibernateUtil.shutdown();
    }
}
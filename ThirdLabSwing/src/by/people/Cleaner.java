package by.people;

import by.companyPackage.Company;
import by.graphicInterface.Gui;

import javax.swing.*;

public class Cleaner extends Employee {

    private static Cleaner Instance;

    public static Cleaner GetInstance(){
        if(Instance == null){
            Instance = new Cleaner();
        }
        return Instance;
    }
    /**
     * Basic constructor
     */
    public Cleaner() {
        super("Cleaner", 100);
    }

    public void clean() {
        Gui.GetInstance().cleanerTask.setText("Убираю");
    }

    @Override
    public void setTextSalary() {
        Gui.GetInstance().cleanerSalary.setText(getTextSalary());
    }
}

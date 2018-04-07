package by.people;

import by.companyPackage.Company;
import by.graphicInterface.Gui;

import javax.swing.*;

public class Coder extends Employee {

    private static Coder Instance;

    public static Coder GetInstance(){
        if(Instance == null){
            Instance = new Coder();
        }
        return Instance;
    }
    /**
     * Basic constructor
     */
    public Coder(){
        super("Программист", 200);
    }
    public Coder(int num) {
        super("Программист", 200);
        this.numCoder = num;
    }

    @Override
    public void setTextSalary(){
        Gui.GetInstance().coderSalary.setText(getTextSalary());
    }


    public void writeCode(){
        try {
            if (Company.GetInstance().getTasks().size() != 0) {
                Gui.GetInstance().coderTaskLabel.setText(Company.GetInstance().getTasks().get(0) + " выполнена");
                Company.GetInstance().getCoders().get(Gui.GetInstance().num - 1).quantityExecutedTask++;
                Company.GetInstance().getTasks().remove(0);
            }else Gui.GetInstance().coderTaskLabel.setText("Нет задач");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Нет программистов");
        }


    }

    private int numCoder;
    private int quantityExecutedTask = 0;

    public int getQuantityExecutedTask() {
        return quantityExecutedTask;
    }

    public void setQuantityExecutedTask(int quantityExecutedTask) {
        this.quantityExecutedTask = quantityExecutedTask;
    }
}
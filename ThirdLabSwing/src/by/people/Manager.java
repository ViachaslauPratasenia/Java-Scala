package by.people;

import by.companyPackage.Company;
import by.graphicInterface.Gui;

import javax.swing.*;

public class Manager extends Employee{
    private static Manager Instance;

    public static Manager GetInstance(){
        if(Instance == null){
            Instance = new Manager();
        }
        return Instance;
    }

    private final int AWARD = 20;

    /**
     * Basic constructor
     */
    public Manager() {
        super("Manager", 500);
    }

    /**
     * This method add task to list
     */
    public void setTask(){
        Company.GetInstance().setTasks();
        JOptionPane.showMessageDialog(null, "Задача " + Company.GetInstance().getQuantityTask() + " добавлена");
    }

    /**
     * This method for award selected coder
     */
    public void award(){
        try{
            Company.GetInstance().getCoders().get(Gui.GetInstance().num - 1).
                    setMoney(Company.GetInstance().getCoders().get(Gui.GetInstance().num - 1).getMoney() + AWARD);
            Gui.GetInstance().coderSalary.setText(Company.GetInstance().getCoders().get(Gui.GetInstance().num - 1).getTextSalary());
            JOptionPane.showMessageDialog(null, "Программист премирован");
        }catch (IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Нет программистов");
        }

    }

    @Override
    public void setTextSalary() {
        Gui.GetInstance().managerSalary.setText(getTextSalary());
    }
}


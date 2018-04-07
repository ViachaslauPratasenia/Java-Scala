package by.companyPackage;

import by.graphicInterface.Gui;
import by.people.*;

import javax.swing.*;
import java.util.ArrayList;

public class Company {

    private static Company Instance;

    public static Company GetInstance(){
        if(Instance == null){
            Instance = new Company();
        }
        return Instance;
    }

    public Company(){
        this.title = "Company";
    }

    private final int RAISE_SALARY = 100;
    private final int CODER_SALARY = 200;
    private final int CLEANER_SALARY = 100;
    private final int MANAGER_SALARY = 500;

    /**
     * This method add task in array list
     */
    public void setTasks(){
        tasks.add("Задача " + quantityTask);
        quantityTask++;
    }

    /**
     * This method increment coder's quantity and set this in label
     */
    public void addCoder(){
        quantityCoder++;
        Company.GetInstance().getCoders().add(new Coder(quantityCoder));
        Gui.GetInstance().coderQuantityLabel.setText("Количество : " + quantityCoder);
        Gui.GetInstance().coderComboBox.removeAllItems();
        for(int i = 1; i <= quantityCoder; i++){
            Gui.GetInstance().coderComboBox.addItem(i);
        }
    }

    /**
     * This method increment cleaner's quantity and set this in label
     */
    public void addCleaner(){
        quantityCleaner++;
        Gui.GetInstance().cleanerQuantity.setText("Количество : " + quantityCleaner);
    }

    public int getQuantityTask(){
        return quantityTask;
    }

    public int getQuantityCoder(){
        return quantityCoder;
    }

    public void setBudget(){
        Gui.GetInstance().companyBudget.setText("Бюджет :" + budget);
    }

    /**
     * This method get salary for employers
     */
    public void getSalary(){
        try {
            if(budget > CODER_SALARY + MANAGER_SALARY + CLEANER_SALARY) {
                Company.GetInstance().getCoders().get(Gui.GetInstance().num - 1).
                        setMoney(Company.GetInstance().getCoders().get(Gui.GetInstance().num - 1).getMoney() + CODER_SALARY);
                Gui.GetInstance().coderSalary.setText(Company.GetInstance().getCoders().get(Gui.GetInstance().num - 1).getTextSalary());
                Manager.GetInstance().setMoney(Manager.GetInstance().getMoney() + MANAGER_SALARY);
                Gui.GetInstance().managerSalary.setText(Manager.GetInstance().getTextSalary());
                Cleaner.GetInstance().setMoney(Cleaner.GetInstance().getMoney() + CLEANER_SALARY);
                Gui.GetInstance().cleanerSalary.setText(Cleaner.GetInstance().getTextSalary());
                budget = budget - CODER_SALARY - CLEANER_SALARY - MANAGER_SALARY;
                Gui.GetInstance().companyBudget.setText("Бюджет :" + budget);
            }
            else
                JOptionPane.showMessageDialog(null, "Денег нет, но вы держитесь");
        }catch (IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null,"Нет программистов");
        }

    }

    /**
     * This method raise salary for selected coder
     */
    public void raiseSalary(){
        try{
            if(Company.GetInstance().getQuantityTask() <= Company.GetInstance().getCoders().get
                    (Gui.GetInstance().num - 1).getQuantityExecutedTask()){
                JOptionPane.showMessageDialog(null, "Зарплата увеличена");
                Company.GetInstance().getCoders().get(Gui.GetInstance().num - 1).setMoney
                        (Company.GetInstance().getCoders().get(Gui.GetInstance().num - 1).getMoney() + RAISE_SALARY);
                Gui.GetInstance().coderSalary.setText(Company.GetInstance().getCoders().get
                        (Gui.GetInstance().num - 1).getTextSalary());
            }
            else JOptionPane.showMessageDialog(null, "Не заслужил");
        }catch (IndexOutOfBoundsException e){
           JOptionPane.showMessageDialog(null, "Нет рабочих");
        }
        catch (Exception e){

        }

    }

    public ArrayList<String> getTasks() {
        return tasks;
    }

    public ArrayList<Coder> getCoders() {
        return coders;
    }

    public int getQuantityCleaner() {
        return quantityCleaner;
    }

    private int budget = 100000;
    private String title;
    private int quantityTask;
    private ArrayList<String> tasks = new ArrayList<>();
    private int quantityCoder = 0;
    private int quantityCleaner;
    private ArrayList<Coder> coders = new ArrayList<>();
}


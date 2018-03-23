import javax.swing.*;

public class Manager extends Employee {
    public Manager() {
        super("Manager", 100);
    }

    Company company = new Company();

    /**
     * This method get task's information from text field
     * and push it in array list with help method setTasks
     */
    public void setTask(){
        company.setTasks(Gui.managerTextField.getText());
        Gui.managerTextField.setText(null);
        JOptionPane.showMessageDialog(null, "Задача добавлена");
    }

    /**
     * This method call method checkMethod for print tasks in console
     */
    public void checkMethod(){
        company.printTasks();
    }
}

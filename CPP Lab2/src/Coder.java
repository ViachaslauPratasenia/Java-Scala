public class Coder extends Employee {

    public Coder() {
        super("Coder", 500);
    }

    /**
     * This method set text and task in gui
     */
    public void writeCode(){
        Gui.GetInstance().coderTaskLabel.setText("Пишу код задачи :");
        Gui.GetInstance().coderInputTaskLabel.setText(Gui.GetInstance().managerTextField.getText());
    }

}

public class Coder extends Employee {

    public Coder() {
        super("Coder", 500);
    }

    /**
     * This method set text and task in gui
     */
    public void writeCode(){
        Gui.coderTaskLabel.setText("Пишу код задачи :");
        Gui.coderInputTaskLabel.setText(Gui.managerTextField.getText());
    }

}

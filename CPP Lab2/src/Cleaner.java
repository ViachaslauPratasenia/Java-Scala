public class Cleaner extends Employee {

    public Cleaner() {
        super("Cleaner", 200);
    }

    /**
     * This method set text and task in gui
     */
    public void clean(){
        Gui.cleanerTask.setText("Убираю");
    }

}

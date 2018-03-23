import java.util.ArrayList;

public class Company {
    public Company(){
        this.title = "Company";
    }

    /**
     * This method add task in array list
     * @param input
     *          input string
     */
    public void setTasks(String input){
        tasks.add(input);
    }

    /**
     * This method increment coder's quantity and set this in label
     */
    public void addCoder(){
        quantityCoder++;
        Gui.coderQuantityLabel.setText("Количество : " + quantityCoder);
    }

    /**
     * This method increment cleaner's quantity and set this in label
     */
    public void addCleaner(){
        quantityCleaner++;
        Gui.cleanerQuantity.setText("Количество : " + quantityCleaner);
    }

    /**
     * This method write in console tasks
     */
    public void printTasks(){
        for(String a : tasks) System.out.println(a);
        System.out.println();
    }

    public ArrayList<String> getTasks() {
        return tasks;
    }

    private String title;
    private ArrayList<String> tasks = new ArrayList<>();
    private int quantityCoder;
    private int quantityCleaner;
}

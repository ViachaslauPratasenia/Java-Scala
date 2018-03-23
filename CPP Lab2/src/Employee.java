/**
 * This class is abstract class for class Coder and class Cleaner
 */
public class Employee {
    /**
     * Basic constructor
     * @param name name employee
     * @param money salary employee
     */
    public Employee(String name, int money){
        this.name = name;
        this.money = money;
    }

    public String name;
    private int money;
}

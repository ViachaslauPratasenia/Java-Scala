package by.people;

/**
 * This class is superclass for class Coder and class Cleaner
 */
public abstract class Employee {
    /**
     * Basic constructor
     * @param name name employee
     * @param money salary employee
     */
    public Employee(String name, int money){
        this.name = name;
        this.money = money;
    }

    public String getTextSalary(){
        return "Зарплата : " + money;
    }

    public int getMoney(){
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public abstract void setTextSalary();

    private String name;
    private int money;
}

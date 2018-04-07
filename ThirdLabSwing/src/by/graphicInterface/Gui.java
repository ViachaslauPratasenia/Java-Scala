package by.graphicInterface;

import by.companyPackage.Company;
import by.people.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Gui implements ActionListener {

    private static Gui Instance;

    public static Gui GetInstance(){
        if(Instance == null){
            Instance = new Gui();
        }
        return Instance;
    }

    public Gui(){
        frame = new JFrame("Second Lab");
        JPanel finalPanel = new JPanel();

        finalPanel.add(createFirstPanel());
        finalPanel.add(createSecondPanel());
        finalPanel.add(createThirdPanel());
        finalPanel.add(createFourthPanel());
        frame.add(finalPanel);

        frame.pack();
        frame.setSize(800,200);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method create panel with elements of director gui
     * @return panel with elements of director gui
     */
    public JPanel createFirstPanel(){
        managerLabel = new JLabel("Директор");
        managerButton = new JButton("Установить задачу");
        managerAwardButton = new JButton("Премировать");
        managerSalary = new JLabel();

        JPanel managerPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(managerPanel, BoxLayout.Y_AXIS);
        managerPanel.setLayout(boxLayout);
        managerPanel.setBorder(BorderFactory.createEmptyBorder(5,10,10,10));

        managerButton.addActionListener(this);
        managerAwardButton.addActionListener(this);

        managerPanel.add(managerLabel);
        managerPanel.add(managerButton);
        managerPanel.add(managerAwardButton);
        managerPanel.add(managerSalary);

        return managerPanel;
    }

    /**
     * This method create panel with elements of company gui
     * @return panel with elements of company gui
     */
    public JPanel createSecondPanel(){
        companyLabel = new JLabel("Компания");
        hireCoder = new JButton("Нанять программиста");
        hireCleaner = new JButton("Нанять уборщика");
        getSalaryButton = new JButton("Выдать зарплату");
        companyBudget = new JLabel();


        JPanel companyPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(companyPanel, BoxLayout.Y_AXIS);
        companyPanel.setLayout(boxLayout);
        companyPanel.setBorder(BorderFactory.createEmptyBorder(3,10,20,10));


        hireCoder.addActionListener(this);
        hireCleaner.addActionListener(this);
        getSalaryButton.addActionListener(this);

        companyPanel.add(companyLabel);
        companyPanel.add(hireCoder);
        companyPanel.add(hireCleaner);
        companyPanel.add(getSalaryButton);
        companyPanel.add(companyBudget);

        return companyPanel;
    }

    /**
     * This method create panel with elements of coder gui
     * @return panel with elements of coder gui
     */
    public JPanel createThirdPanel(){
        coderLabel = new JLabel("Программист");
        coderComboBox = new JComboBox<>();
        coderComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                num = coderComboBox.getSelectedIndex() + 1;
                //coderSalary.setText(Company.GetInstance().getCoders().get(num - 1).getTextSalary());
            }
        });
        coderButton = new JButton("Выполнить задачу");
        coderTaskLabel = new JLabel("Нет задачи");
        coderInputTaskLabel = new JLabel();
        coderQuantityLabel = new JLabel();
        coderQuantityLabel.setText("Некому писать код");
        coderAskButton = new JButton("Попросить больше денег");
        coderSalary = new JLabel();

        coderButton.addActionListener(this);
        coderAskButton.addActionListener(this);

        JPanel coderPanel = new JPanel();

        BoxLayout boxLayout = new BoxLayout(coderPanel, BoxLayout.Y_AXIS);
        coderPanel.setLayout(boxLayout);
        coderPanel.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));

        coderPanel.add(coderLabel);
        coderPanel.add(coderComboBox);
        coderPanel.add(coderButton);
        coderPanel.add(coderQuantityLabel);
        coderPanel.add(coderTaskLabel);
        coderPanel.add(coderInputTaskLabel);
        coderPanel.add(coderSalary);
        coderPanel.add(coderAskButton);

        return coderPanel;
    }

    /**
     * This method create panel with elements of cleaner gui
     * @return panel with elements of cleaner gui
     */
    public JPanel createFourthPanel(){
        cleanerLabel = new JLabel("Уборщик");
        cleanerButton = new JButton("Убрать");
        cleanerQuantity = new JLabel();
        cleanerQuantity.setText("Некому убирать");
        cleanerTask = new JLabel();
        cleanerSalary = new JLabel();

        cleanerButton.addActionListener(this);

        JPanel cleanerPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(cleanerPanel, BoxLayout.Y_AXIS);
        cleanerPanel.setLayout(boxLayout);
        cleanerPanel.setBorder(BorderFactory.createEmptyBorder(5,10,10,10));
        cleanerPanel.add(cleanerLabel);
        cleanerPanel.add(cleanerButton);
        cleanerPanel.add(cleanerQuantity);
        cleanerPanel.add(cleanerTask);
        cleanerPanel.add(cleanerSalary);

        return cleanerPanel;
    }

    private JLabel managerLabel;
    private JButton managerButton;

    public JLabel managerSalary;

    private JLabel companyLabel;
    private JButton hireCoder;
    private JButton hireCleaner;
    private JButton getSalaryButton;

    public JLabel companyBudget;

    private JLabel coderLabel;
    private JButton coderButton;
    private JButton coderAskButton;

    private JLabel cleanerLabel;
    private JButton cleanerButton;

    public JComboBox<Integer> coderComboBox;
    public JLabel coderInputTaskLabel;
    public JLabel coderTaskLabel;
    public JLabel coderQuantityLabel;
    public JLabel coderSalary;

    public JLabel cleanerQuantity;
    public JLabel cleanerTask;
    public JLabel cleanerSalary;

    private JButton managerAwardButton;

    public int num;

    public Company company = new Company();
    public Manager manager = new Manager();
    public Coder coder = new Coder();
    public Cleaner cleaner = new Cleaner();

    public JFrame frame;

    /**
     * This method realises handler for gui's buttons
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == hireCoder) company.addCoder();
        if(event.getSource() == hireCleaner) company.addCleaner();
        if(event.getSource() == coderButton) coder.writeCode();
        if(event.getSource() == cleanerButton) cleaner.clean();
        if(event.getSource() == managerButton) manager.setTask();
        if(event.getSource() == managerAwardButton) manager.award();
        if(event.getSource() == getSalaryButton) company.getSalary();
        if(event.getSource() == coderAskButton) company.raiseSalary();
    }
}


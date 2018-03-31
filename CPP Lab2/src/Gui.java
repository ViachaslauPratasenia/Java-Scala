import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {

    private static Gui Instance;

    public static Gui GetInstance(){
        if(Instance == null){
            Instance = new Gui();
        }
        return Instance;
    }

    public Gui(){
        JFrame frame = new JFrame("Second Lab");
        JPanel finalPanel = new JPanel();

        finalPanel.add(createFirstPanel());
        finalPanel.add(createSecondPanel());
        finalPanel.add(createThirdPanel());
        finalPanel.add(createFourthPanel());
        frame.add(finalPanel);

        frame.pack();
        frame.setSize(650,150);
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
        managerTextField = new JTextField();
        managerButton = new JButton("Установить задачу");
        checkButton = new JButton("Проверка");

        JPanel managerPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(managerPanel, BoxLayout.Y_AXIS);
        managerPanel.setLayout(boxLayout);
        managerPanel.setBorder(BorderFactory.createEmptyBorder(5,10,10,10));

        managerButton.addActionListener(this);
        checkButton.addActionListener(this);

        managerPanel.add(managerLabel);
        managerPanel.add(managerTextField);
        managerPanel.add(managerButton);
        managerPanel.add(checkButton);

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

        JPanel companyPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(companyPanel, BoxLayout.Y_AXIS);
        companyPanel.setLayout(boxLayout);
        companyPanel.setBorder(BorderFactory.createEmptyBorder(3,10,20,10));


        hireCoder.addActionListener(this);
        hireCleaner.addActionListener(this);

        companyPanel.add(companyLabel);
        companyPanel.add(hireCoder);
        companyPanel.add(hireCleaner);

        return companyPanel;
    }

    /**
     * This method create panel with elements of coder gui
     * @return panel with elements of coder gui
     */
    public JPanel createThirdPanel(){
        coderLabel = new JLabel("Программист");
        coderButton = new JButton("Писать код");
        coderTaskLabel = new JLabel();
        coderInputTaskLabel = new JLabel();
        coderQuantityLabel = new JLabel();
        coderQuantityLabel.setText("Некому писать код");

        coderButton.addActionListener(this);

        JPanel coderPanel = new JPanel();

        BoxLayout boxLayout = new BoxLayout(coderPanel, BoxLayout.Y_AXIS);
        coderPanel.setLayout(boxLayout);
        coderPanel.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));

        coderPanel.add(coderLabel);
        coderPanel.add(coderButton);
        coderPanel.add(coderQuantityLabel);
        coderPanel.add(coderTaskLabel);
        coderPanel.add(coderInputTaskLabel);

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

        cleanerButton.addActionListener(this);

        JPanel cleanerPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(cleanerPanel, BoxLayout.Y_AXIS);
        cleanerPanel.setLayout(boxLayout);
        cleanerPanel.setBorder(BorderFactory.createEmptyBorder(5,10,10,10));
        cleanerPanel.add(cleanerLabel);
        cleanerPanel.add(cleanerButton);
        cleanerPanel.add(cleanerQuantity);
        cleanerPanel.add(cleanerTask);

        return cleanerPanel;
    }

    private JLabel managerLabel;
    private JButton managerButton;

    private JLabel companyLabel;
    private JButton hireCoder;
    private JButton hireCleaner;

    private JLabel coderLabel;
    private JButton coderButton;

    private JLabel cleanerLabel;
    private JButton cleanerButton;

    public JTextField managerTextField;
    public JLabel coderInputTaskLabel;
    public JLabel coderTaskLabel;
    public JLabel coderQuantityLabel;

    public JLabel cleanerQuantity;
    public JLabel cleanerTask;

    private JButton checkButton;

    public Company company = new Company();
    public Manager manager = new Manager();


    /**
     * This method realises handler for gui's buttons
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == hireCoder) company.addCoder();
        if(event.getSource() == hireCleaner) company.addCleaner();
        if(event.getSource() == coderButton) new Coder().writeCode();
        if(event.getSource() == cleanerButton) new Cleaner().clean();
        if(event.getSource() == managerButton) manager.setTask();
        if(event.getSource() == checkButton) manager.checkMethod();
    }
}

package prjCalculatrice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatriceFrm extends JFrame implements ActionListener {
    // Propriétés statiques
    private static final String DIGIT = "DIGIT_";
    private static final String OPE_ADD = "OPE_ADD";
    private static final String OPE_MUL = "OPE_MUL";
    private static final String OPE_DIV = "OPE_DIV";
    private static final String OPE_SOU = "OPE_SOU";
    private static final String OPE_CALC = "OPE_CALC";
    private static final String OPE_CLEAR = "OPE_CLEAR";

    // Propriétés d'instance
    private double amount;
    private String current,lastOperation;
    private JTextField amountField;

    public CalculatriceFrm(){
        setTitle("Calculatrice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(getParent());
        setResizable(false);

        resetOperation();

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        setSize(new Dimension(250, 350));

        contentPane.add(panelScreen(), BorderLayout.NORTH);
        contentPane.add(panelOperations(), BorderLayout.EAST);
        contentPane.add(panelDigits(), BorderLayout.CENTER);

        setVisible(true);
    }

    private Component panelScreen() {
        final JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,1));

        amountField = new JTextField("0.0");
        amountField.setHorizontalAlignment(JTextField.RIGHT);
        amountField.setEditable(false);
        Font font = new Font("monospace", Font.BOLD, 25);
        amountField.setFont(font);
        panel.add(amountField);

        return panel;
    }

    private Component panelOperations() {
        final JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));

        JButton	div	= new JButton("/");
        div.setActionCommand(OPE_DIV);
        div.addActionListener(this);
        panel.add(div);

        JButton	mul	= new JButton("*");
        mul.setActionCommand(OPE_MUL);
        mul.addActionListener(this);
        panel.add(mul);

        JButton	sou	= new JButton("-");
        sou.setActionCommand(OPE_SOU);
        sou.addActionListener(this);
        panel.add(sou);

        JButton	add = new JButton("+");
        add.setActionCommand(OPE_ADD);
        add.addActionListener(this);
        panel.add(add);

        return panel;
    }
    private Component panelDigits() {
        final JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,3));

        for(Integer i=1; i<=9; i++) {
            JButton button = new JButton(i.toString());
            button.setActionCommand(DIGIT + i);
            button.addActionListener(this);
            panel.add(button);
        }

        JButton clear = new JButton("C");
        clear.setActionCommand(OPE_CLEAR);
        clear.addActionListener(this);
        panel.add(clear);

        JButton zero = new JButton("0");
        zero.setActionCommand(DIGIT + "0");
        zero.addActionListener(this);
        panel.add(zero);

        JButton result = new JButton("=");
        result.setActionCommand(OPE_CALC);
        result.addActionListener(this);
        panel.add(result);

        return panel;
    }

    public void actionPerformed(ActionEvent event) {
        final String command = event.getActionCommand();
        if(command.startsWith(DIGIT)) {
            this.current += command.substring(DIGIT.length());
        } else if(command.equals(OPE_CLEAR)) {
            resetOperation();
        } else {
            resultOperation(command);
            lastOperation = command;
        }
        refreshScreen();
    }
    private void resultOperation(final String currentOperation) {
        if(this.current.isEmpty()) {
            return;
        }
        final double value = Integer.parseInt(this.current,10);
        if(lastOperation.equals(OPE_ADD)) {
            this.amount += value;
        }
        else if(lastOperation.equals(OPE_SOU)) {
            this.amount -= value;
        }
        else if(lastOperation.equals(OPE_MUL)) {
            this.amount *= value;
        }
        else if(lastOperation.equals(OPE_DIV)) {
            this.amount /= value;
        }
        this.current = "";
    }

    private void refreshScreen() {
        String value = current;
        if(value.isEmpty()) value += this.amount;
        this.amountField.setText(value);
    }

    private void resetOperation() {
        this.amount = 0.0;
        this.current = "";
        this.lastOperation = OPE_ADD;
    }
}

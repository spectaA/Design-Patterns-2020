package prjConversionCouleurs;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConvCoulFrm extends JFrame {

    private JSlider redSlider;
    private JSlider greenSlider;
    private JSlider blueSlider;

    private JSpinner redSpinner;
    private JSpinner greenSpinner;
    private JSpinner blueSpinner;

    private JTextField hexField;

    public ConvCoulFrm() {

        setTitle("Conversion de couleurs");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(getParent());
        setResizable(false);
        setSize(new Dimension(250, 350));

        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        pane.add(rgb(), BorderLayout.CENTER);
        pane.add(hex(), BorderLayout.SOUTH);

        setVisible(true);

        ((JSpinner.DefaultEditor) redSpinner.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor) greenSpinner.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor) blueSpinner.getEditor()).getTextField().setEditable(false);
    }

    private Component rgb() {
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(rgbLabels(), BorderLayout.NORTH);
        panel.add(rgbSliders(), BorderLayout.CENTER);
        panel.add(rgbSpinners(), BorderLayout.SOUTH);
        panel.add(new JLabel("Déc ="), BorderLayout.WEST);

        return panel;
    }

    private Component hex() {
        final JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Hex = ");
        panel.add(label);

        hexField = new JTextField("0xFFFFFF");
        hexField.setEditable(false);
        panel.add(hexField);

        return panel;
    }

    private Component rgbLabels() {
        final JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,3));

        JLabel redLabel = new JLabel("Rouge");
        redLabel.setBackground(Color.red);
        redLabel.setOpaque(true);
        panel.add(redLabel);

        JLabel greenLabel = new JLabel("Vert");
        greenLabel.setBackground(Color.green);
        greenLabel.setOpaque(true);
        panel.add(greenLabel);

        JLabel blueLabel = new JLabel("Bleu");
        blueLabel.setBackground(Color.blue);
        blueLabel.setOpaque(true);
        panel.add(blueLabel);

        return panel;
    }

    private Component rgbSliders() {
        final JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,3));

        redSlider = new JSlider(1, 0, 255, 255);
        redSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                refreshSliders();
            }
        });
        panel.add(redSlider);
        greenSlider = new JSlider(1, 0, 255, 255);
        greenSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                refreshSliders();
            }
        });
        panel.add(greenSlider);
        blueSlider = new JSlider(1, 0, 255, 255);
        blueSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                refreshSliders();
            }
        });
        panel.add(blueSlider);

        return panel;
    }

    private Component rgbSpinners() {
        final JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,3));

        redSpinner = new JSpinner();
        redSpinner.setValue(255);
        redSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                refreshSpinners();
            }
        });
        panel.add(redSpinner);
        greenSpinner = new JSpinner();
        greenSpinner.setValue(255);
        greenSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                refreshSpinners();
            }
        });
        panel.add(greenSpinner);
        blueSpinner = new JSpinner();
        blueSpinner.setValue(255);
        blueSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                refreshSpinners();
            }
        });
        panel.add(blueSpinner);

        return panel;
    }

    private void refreshSliders() {
        int red = redSlider.getValue();
        int green = greenSlider.getValue();
        int blue = blueSlider.getValue();
        displayHex(red, green, blue);
        redSpinner.setValue(red);
        greenSpinner.setValue(green);
        blueSpinner.setValue(blue);
    }

    private void refreshSpinners() {
        int red = (int) redSpinner.getValue();
        int green = (int) greenSpinner.getValue();
        int blue = (int) blueSpinner.getValue();
        displayHex(red, green, blue);
        redSlider.setValue(red);
        greenSlider.setValue(green);
        blueSlider.setValue(blue);
    }

    private void displayHex(int r, int g, int b) {
        String text = "0x" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);

        hexField.setText(text);
    }
}

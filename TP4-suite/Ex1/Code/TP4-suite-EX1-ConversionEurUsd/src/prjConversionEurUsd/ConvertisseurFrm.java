package prjConversionEurUsd;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class ConvertisseurFrm extends JFrame {

    public ConvertisseurFrm() {
        super("Convertisseur EUR-USD");

        this.setResizable(false);
        this.setSize(300, 120);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Panel 1
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

        JTextField fieldEUR = new JTextField();
        fieldEUR.setHorizontalAlignment(SwingConstants.RIGHT);
        fieldEUR.setPreferredSize(new Dimension(100, 20));
        panel1.add(fieldEUR);
        panel1.add(new JLabel("EUR"));

        ButtonGroup groupe = new ButtonGroup();
        JRadioButton montant = new JRadioButton("Montant");
        montant.setSelected(true);
        groupe.add(montant);
        panel1.add(montant);
        JRadioButton taxe = new JRadioButton("Taxe");
        groupe.add(taxe);
        panel1.add(taxe);

        // Panel 2
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel panelMontant = new JPanel();
        JTextField fieldUSD = new JTextField();
        fieldUSD.setHorizontalAlignment(SwingConstants.RIGHT);
        fieldUSD.setPreferredSize(new Dimension(100, 20));
        panelMontant.add(fieldUSD);
        panelMontant.add(new JLabel("USD"));
        panel2.add(panelMontant);

        JPanel panelTaxe = new JPanel();
        JTextField fieldTTC = new JTextField();
        fieldTTC.setHorizontalAlignment(SwingConstants.RIGHT);
        fieldTTC.setPreferredSize(new Dimension(100, 20));
        panelTaxe.add(fieldTTC);
        panelTaxe.add(new JLabel("TTC"));
        panel2.add(panelTaxe);
        panelTaxe.setVisible(false);

        JTextField fieldTaxe = new JTextField("21");
        fieldTaxe.setPreferredSize(new Dimension(50, 20));
        fieldTaxe.setEnabled(false);
        panel2.add(fieldTaxe);
        panel2.add(new JLabel("%"));

        // Fenetre
        JPanel fenetre = new JPanel();
        fenetre.setLayout(new BoxLayout(fenetre, BoxLayout.PAGE_AXIS));
        fenetre.add(panel1);
        fenetre.add(panel2);

        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(fenetre);
        this.setVisible(true);

        // Events
        fieldEUR.getDocument().addDocumentListener(new DocumentListener() {
            private void updateData() {
                try {

                    Double val = Double.parseDouble(fieldEUR.getText());
                    DecimalFormat df = new DecimalFormat("###.##");

                    fieldUSD.setText(df.format(val * 1.09));

                    Double taxe = Double.parseDouble(fieldTaxe.getText());
                    fieldTTC.setText(df.format(val + (val * taxe / 100)));

                } catch (NumberFormatException e) {
                    System.out.println("Nombre invalide");
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {}
            @Override
            public void insertUpdate(DocumentEvent e) { updateData(); }
            @Override
            public void removeUpdate(DocumentEvent e)  { updateData(); }

        });

        montant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelMontant.setVisible(true);
                panelTaxe.setVisible(false);
                fieldTaxe.setEnabled(false);
            }
        });

        taxe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelMontant.setVisible(false);
                panelTaxe.setVisible(true);
                fieldTaxe.setEnabled(true);
            }
        });

    }

}

package prjCompteBancaireSuite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompteBancaireFrm extends JFrame {

    private JLabel jLabel;
    private JTextField jtf;
    private JButton jb;
    private JLabel jlSolde;
    private JTextArea jtaHistorique;

    private CompteBancaire compteBancaire;

    public CompteBancaireFrm(CompteBancaire cb) {
        super("Compte bancaire");

        compteBancaire = cb;

        setSize(new Dimension(450, 200));
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jLabel = new JLabel("Montant :");
        getContentPane().add(jLabel);

        jtf = new JTextField("20");
        jtf.setColumns(5);
        getContentPane().add(jtf);

        jb = new JButton("Ajouter montant");
        jb.addActionListener(new AjouteMontantEcouteur());
        getContentPane().add(jb);

        jlSolde = new JLabel();
        getContentPane().add(jlSolde);

        jtaHistorique = new JTextArea();
        jtaHistorique.setRows(7);
        jtaHistorique.setColumns(40);
        jtaHistorique.setWrapStyleWord(true);
        jtaHistorique.setEditable(false);
        JScrollPane jsp  = new JScrollPane(jtaHistorique);
        jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(jsp);

        displaySolde();
    }

    private void displaySolde() {
        jlSolde.setText("Votre solde : " + compteBancaire.getSolde());
        jtaHistorique.append("Solde : " + compteBancaire.getSolde() + "\n");

    }

    private class AjouteMontantEcouteur implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            compteBancaire.depot(Double.parseDouble(jtf.getText()));
            displaySolde();
        }
    }

}

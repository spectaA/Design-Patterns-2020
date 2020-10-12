package prjSelfBanking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BanqueFrm extends JFrame {

    private Banque laBanque = new Banque();
    private JTextArea infoZone;

    public BanqueFrm() {
        super("Self banking");

        laBanque.addCompte(new CompteCourant(50));
        laBanque.addCompte(new CompteEpargne(500));
        laBanque.addCompte(new ComptePayant(5));

        this.setResizable(false);
        this.setSize(420, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Ligne 1 : Montant et JLabelField
        JPanel b1 = new JPanel();
        b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));

        b1.add(Box.createRigidArea(new Dimension(50, 0)));
        b1.add(new JLabel("Montant"));
        b1.add(Box.createRigidArea(new Dimension(50, 0)));
        JTextField montantField = new JTextField();
        b1.add(montantField);

        // Ligne 2 : Compte et JComboBox
        JPanel b2 = new JPanel();
        b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));

        b2.add(Box.createRigidArea(new Dimension(50, 0)));
        b2.add(new JLabel("Depuis"));
        b2.add(Box.createRigidArea(new Dimension(50, 0)));
        JComboBox comboBoxDepuis = new JComboBox(this.laBanque.collectionComptes().toArray());
        b2.add(comboBoxDepuis);

        // Ligne 2 : Compte et JComboBox
        JPanel b3 = new JPanel();
        b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));

        b3.add(Box.createRigidArea(new Dimension(50, 0)));
        b3.add(new JLabel("Vers"));
        b3.add(Box.createRigidArea(new Dimension(50, 0)));
        JComboBox comboBoxVers = new JComboBox(this.laBanque.collectionComptes().toArray());
        b3.add(comboBoxVers);

        // Ligne 3 : Transaction + JRadioButton
//        JPanel b3 = new JPanel();
//
//        b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
//
//        b3.add(Box.createRigidArea(new Dimension(50, 0)));
//        b3.add(new JLabel("Transaction"));
//        b3.add(Box.createRigidArea(new Dimension(50, 0)));
//
//        JRadioButton radio1 = new JRadioButton("Dépot", true);
//        b3.add(radio1);
//        b3.add(Box.createRigidArea(new Dimension(20, 0)));
//        JRadioButton radio2 = new JRadioButton("Retrait");
//        b3.add(radio2);
//        // Radio button group
//        ButtonGroup bg = new ButtonGroup();
//        bg.add(radio1);
//        bg.add(radio2);

        // ligne 4 : Bouton valider + bouton calcul
        JPanel b4 = new JPanel();

        b4.setLayout(new BoxLayout(b4, BoxLayout.LINE_AXIS));

        b4.add(Box.createRigidArea(new Dimension(50, 0)));
        JButton boutonValider = new JButton("Valider");
        boutonValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double valeur = Double.parseDouble(montantField.getText());
                    int indexDepuis = comboBoxDepuis.getSelectedIndex();
                    int indexVers = comboBoxVers.getSelectedIndex();
                    Versement(indexDepuis, indexVers, valeur);
//                    if(radio1.isSelected()) {
//                        Depot(valeur, index);
//                    } else {
//                        Retrait(valeur, index);
//                    }

                } catch (Exception exception) {
                    System.out.println("Veuillez insérer des valeurs correctes");
                }
            }
        });
        b4.add(boutonValider);
        b4.add(Box.createRigidArea(new Dimension(25, 0)));
        JButton boutonCalcul = new JButton("Calculer les intérêts");
        boutonCalcul.setEnabled(false);
//        boutonCalcul.addActionListener(new CalculListener());
        b4.add(boutonCalcul);

        // Ligne 5 : JTextArea
        JPanel b5 = new JPanel();

        b5.setLayout(new BoxLayout(b5, BoxLayout.LINE_AXIS));

        b5.add(Box.createRigidArea(new Dimension(50, 0)));
        infoZone = new JTextArea();
        infoZone.setColumns(10);
        infoZone.setRows(8);
        JScrollPane scrollPane  = new JScrollPane(infoZone);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        b5.add(scrollPane);

        // Affichage et arrangement sur la fenêtre
        JPanel fenetre = new JPanel();
        //On positionne maintenant ces trois lignes en colonne
        fenetre.setLayout(new BoxLayout(fenetre, BoxLayout.PAGE_AXIS));
        fenetre.add(Box.createRigidArea(new Dimension(0, 30)));
        fenetre.add(b1);
        fenetre.add(Box.createRigidArea(new Dimension(0, 30)));
        fenetre.add(b2);
        fenetre.add(Box.createRigidArea(new Dimension(0, 30)));
        fenetre.add(b3);
        fenetre.add(Box.createRigidArea(new Dimension(0, 30)));
        fenetre.add(b4);
        fenetre.add(Box.createRigidArea(new Dimension(0, 30)));
        fenetre.add(b5);

        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(fenetre);
        this.setVisible(true);
    }

//    private void Depot(double valeur, int index) {
//        this.comptes[index].depot(valeur);
//        AfficheSolde(this.comptes[index]);
//    }
//
//    private void Retrait(double valeur, int index) {
//        this.comptes[index].retrait(valeur);
//        AfficheSolde(this.comptes[index]);
//    }

    private void Versement(int indexDepuis, int indexVers, double montant) {
        try {
            this.laBanque.getCompte(indexDepuis).versement(montant, this.laBanque.getCompte(indexVers));
            this.infoZone.append("-----OPÉRATION RÉALISÉE-----\n");
            AfficheSolde(this.laBanque.getCompte(indexDepuis));
            AfficheSolde(this.laBanque.getCompte(indexVers));
            this.infoZone.append("----------------------------------\n");
        } catch (Exception exception) {
            System.out.println("OPÉRATION IMPOSSIBLE");
            this.infoZone.append("<OPÉRATION IMPOSSIBLE>\n");
        }

    }

    private void AfficheSolde(CompteBancaire compte) {
        System.out.println(compte.getDetail());
        this.infoZone.append(compte.getDetail() + "\n");
    }
}

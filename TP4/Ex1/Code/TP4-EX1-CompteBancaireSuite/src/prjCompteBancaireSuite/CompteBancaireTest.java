package prjCompteBancaireSuite;

import javax.swing.*;

public class CompteBancaireTest {
    public static void main(String[] args) {
        JFrame frame = new CompteBancaireFrm(new CompteBancaire(44.3));
        frame.setVisible(true);
    }
}

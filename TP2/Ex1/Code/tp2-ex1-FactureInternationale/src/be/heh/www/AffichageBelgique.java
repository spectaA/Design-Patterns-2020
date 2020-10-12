package be.heh.www;

public class AffichageBelgique implements Affichage {

    @Override
    public void affiche(double montant) {
        System.out.println("Le montant de la facture est de : " + montant + " €");
    }

}

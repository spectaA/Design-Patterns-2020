package be.heh.www;

public class Facture {

    private double montant;
    private Affichage affichage;

    public Facture(double montant) {
        this.montant = montant;
        this.affichage = new AffichageBelgique();
    }

    public void setAffichage(Affichage a) {
        this.affichage = a;
    }

    public void affiche() {
        this.affichage.affiche(this.montant);
    }

}
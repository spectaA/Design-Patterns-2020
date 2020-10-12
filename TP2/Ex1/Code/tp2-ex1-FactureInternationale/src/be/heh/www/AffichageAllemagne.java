package be.heh.www;

public class AffichageAllemagne implements Affichage {

    @Override
    public void affiche(double montant) {
        System.out.println("Der Rechnungsbetrag ist : € " + montant);
    }
}

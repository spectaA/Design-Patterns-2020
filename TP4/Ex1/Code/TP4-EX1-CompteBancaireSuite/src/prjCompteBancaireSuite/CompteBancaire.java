package prjCompteBancaireSuite;

public class CompteBancaire {

    private double solde = 0;

    public CompteBancaire(double solde) {
        this.solde = solde < 0 ? 0 : solde;
    }

    public void depot(double montant) {
        this.solde += montant;
    }

    public double getSolde() {
        return this.solde;
    }

}

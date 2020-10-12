package prjSelfBanking;

import com.sun.jdi.event.StepEvent;

public class CompteBancaire {

    private double solde = 0;
    private String nom;

    public CompteBancaire(double solde, String nom) {
        this.solde = solde < 0 ? 0 : solde;
        this.nom = nom;
    }

    public void depot(double montant) {
        this.solde += montant;
    }

    public void retrait(double montant) {
        if(montant > this.solde) {
            System.out.println("Solde insuffisant");
            throw new IllegalArgumentException();
        } else {
            this.solde -= montant;
        }
    }

    public double getSolde() {
        return this.solde;
    }

    public void versement(double montant, CompteBancaire vers) {
        retrait(montant);
        vers.depot(montant);
    }

    public String getDetail() {
        return "<" + this.nom + "> : solde = " + this.getSolde();
    }

    @Override
    public String toString() {
        return this.nom;
    }
}

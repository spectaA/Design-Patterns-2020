package prjSelfBanking;

public class ComptePayant extends CompteBancaire {

    public ComptePayant(double solde) {
        super(solde, "Compte payant");
    }

    @Override
    public void retrait(double montant) {
        super.retrait(montant * 1.05);
    }

    @Override
    public void depot(double montant) {
        super.depot(montant * 0.95);
    }
}

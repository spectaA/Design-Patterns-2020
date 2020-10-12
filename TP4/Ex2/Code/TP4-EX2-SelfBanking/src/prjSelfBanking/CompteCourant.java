package prjSelfBanking;

public class CompteCourant extends CompteBancaire {

    public CompteCourant(double solde) {
        super(solde, "Compte courant");
    }

    @Override
    public void retrait(double montant) {
        super.retrait(montant * 1.05);
    }
}

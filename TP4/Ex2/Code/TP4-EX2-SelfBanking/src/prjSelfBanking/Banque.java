package prjSelfBanking;

import java.util.ArrayList;

public class Banque {

    private ArrayList<CompteBancaire> lesComptes = new ArrayList<CompteBancaire>();

    public void addCompte(CompteBancaire c) {
        lesComptes.add(c);
    }

    public CompteBancaire getCompte(int index) {
        return lesComptes.get(index);
    }

    public ArrayList<CompteBancaire> collectionComptes() {
        return lesComptes;
    }

}

package be.heh.www;

public class Main {
    public static void main(String[] args) {

        Magasin m1 = new Magasin("magasin 1");
        m1.setProfit(30);

        Magasin m2 = new Magasin("magasin 2");
        m2.setProfit(-5);

        Ville v1 = new Ville("ville 1");
        v1.ajouterMagasin(m1);
        v1.ajouterMagasin(m2);
        v1.soutRapport();

        Magasin m3 = new Magasin("magasin 3");
        m3.setProfit(55);

        Magasin m4 = new Magasin("magasin 4");
        m4.setProfit(10);

        Magasin m5 = new Magasin("magasin 5");
        m5.setProfit(31);

        Ville v2 = new Ville("ville 2");
        v2.ajouterMagasin(m3);
        v2.ajouterMagasin(m4);
        v2.ajouterMagasin(m5);
        v2.soutRapport();

        Province p1 = new Province("province 1");
        p1.ajouterVille(v1);
        p1.ajouterVille(v2);
        p1.soutRapport();

    }
}

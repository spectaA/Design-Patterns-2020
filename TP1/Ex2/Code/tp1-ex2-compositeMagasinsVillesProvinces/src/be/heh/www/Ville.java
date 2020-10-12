package be.heh.www;

import java.util.ArrayList;

public class Ville implements Component {

    // Paramètres

    private String nom;
    private ArrayList<Component> magasins = new ArrayList<Component>();

    // Constructeur

    public Ville(String n) {
        this.nom = n;
    }

    // Méthodes

    public void ajouterMagasin(Component m) {
        magasins.add(m);
    }

    public int getProfit() {
        int profit = 0;
        for (Component m : magasins) {
            profit += m.getProfit();
        }
        return profit;
    }

    public void soutRapport() {
        System.out.println(
                "--------------------\n" +
                this.nom + " : profit : " +
                this.getProfit()
        );
    }
}

package be.heh.www;

import java.util.ArrayList;

public class Province implements Component {

    // Paramètres

    private String nom;
    private ArrayList<Component> villes = new ArrayList<Component>();

    // Constructeur

    public Province(String n) {
        this.nom = n;
    }

    // Méthodes

    public void ajouterVille(Component v) {
        villes.add(v);
    }

    public int getProfit() {
        int profit = 0;
        for (Component v : villes) {
            profit += v.getProfit();
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

package be.heh.www;

public class Magasin implements Component {

    // Paramètres

    private String nom;
    private int profit = 0;

    // Constructeur

    public Magasin(String n) {
        this.nom = n;
    }

    // Méthodes

    public void setProfit(int p) {
        this.profit = p;
    }

    public int getProfit() {
        return this.profit;
    }

    public void soutRapport() {
        System.out.println(
                "--------------------\n" +
                        this.nom + " : profit : " +
                        this.getProfit()
        );
    }

}

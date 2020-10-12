package be.heh.www;

public class Fichier implements Component {

    private String nom;

    public Fichier(String n) {
        this.nom = n;
    }

    public String getNom() {
        return this.nom;
    }

}

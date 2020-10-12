package be.heh.www;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;

public class Dossier implements Component {

    private String nom;
    private ArrayList<Component> fichiers = new ArrayList<Component>();

    public Dossier(String n) {
        this.nom = n;
    }

    public void addFichier(Component f) {
        fichiers.add(f);
    }

    public String getNom() {
        String nom = "˪" + this.nom + " [";
        for (Component f : fichiers) {
            nom += "\r\n " + f.getNom();
        }
        nom += "\r\n]";
        return nom;
    }
}

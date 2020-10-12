package be.heh.www;

import javax.print.Doc;
import javax.sound.midi.Soundbank;

public class Main {

    public static void main(String[] args) {

        Fichier f1 = new Fichier("Fichier 1");
        Fichier f2 = new Fichier("Fichier 2");
        Fichier f3 = new Fichier("Fichier 3");
        Fichier f4 = new Fichier("Fichier 4");

        Dossier d1 = new Dossier("Dossier 1");
        Dossier d2 = new Dossier("Dossier 2");

        d1.addFichier(f1);
        d1.addFichier(f2);

        d2.addFichier(f3);
        d2.addFichier(f4);
        d1.addFichier(d2);

        System.out.println(d1.getNom());

    }

}

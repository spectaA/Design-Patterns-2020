package prjvalidateur;

public class Validateur {

    private Format format;
    private String texte;

    public Validateur(Format f, String t) {
        this.format = f;
        this.texte = t;
    }

    public Boolean isValide() {
        return this.format.isValide(this.texte);
    }

}

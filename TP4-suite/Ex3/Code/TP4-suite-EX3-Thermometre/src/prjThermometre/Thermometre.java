package prjThermometre;

public class Thermometre {

    ControleFrm controle;
    AffichageFrm affichage;

    public Thermometre() {
        this.affichage = new AffichageFrm();
        this.controle = new ControleFrm(this.affichage);
    }

}

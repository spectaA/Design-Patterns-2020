package prjvalidateur;

public class FormatEntier implements Format {

    @Override
    public Boolean isValide(String texte) {
        try {
            Integer.parseInt(texte);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

package prjvalidateur;

public class FormatMail implements Format {

    @Override
    public Boolean isValide(String texte) {
        return texte.indexOf("@") > 0 && texte.indexOf(".") > 0 && texte.length() > 3 ? true : false;
    }
}

package prjvalidateur;

public class Client {
    public static void main(String[] args) {
        String txt="6";
        System.out.println("La chaine de caractère : "+txt);

        Validateur valEntier=new Validateur(new FormatEntier(),txt);
        System.out.println("Est-ce que "+txt+ " est un entier valide ? "+valEntier.isValide());

        Validateur valMail=new Validateur(new FormatMail(),txt);
        System.out.println("Est-ce que "+txt+ " est un mail valide ? "+valMail.isValide());

        System.out.println("----------------------");

        txt="toto@gmail.com";
        System.out.println("La chaine de caractère : "+txt);
        Validateur valEntier2=new Validateur(new FormatEntier(),txt);

        System.out.println("Est-ce que "+txt+ " est un entier valide ? "+valEntier2.isValide());

        Validateur valMail2=new Validateur(new FormatMail(),txt);
        System.out.println("Est-ce que "+txt+ " est un mail valide ? "+valMail2.isValide());
    }
}
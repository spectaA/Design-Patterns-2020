package prjPizzas;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nBonjour, voici votre pizza : \n");

        Pizza maPizza = new PizzaFoureeFromage();

        maPizza = new BoulettesDeViande(maPizza);
        maPizza = new Fromage(maPizza);
        maPizza = new Oignons(maPizza);
        maPizza = new OlivesNoires(maPizza);

        System.out.println(maPizza.getDescription());
        System.out.println(maPizza.getPrix());
    }

}

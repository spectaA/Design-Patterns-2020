package prjPizzas;

public class PizzaFoureeFromage implements Pizza {
    @Override
    public String getDescription() {
        return "Pizza fourée au fromage (10.00)";
    }

    @Override
    public Double getPrix() {
        return 10.0;
    }
}

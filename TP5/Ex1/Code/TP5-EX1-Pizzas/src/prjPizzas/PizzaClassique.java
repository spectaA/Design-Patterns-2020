package prjPizzas;

public class PizzaClassique implements Pizza {
    @Override
    public String getDescription() {
        return "Pizza classique (7.00)";
    }

    @Override
    public Double getPrix() {
        return 7.0;
    }
}

package prjPizzas;

public class Champignons extends PizzaToppings {

    public Champignons(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", champignons (3.00)";
    }

    @Override
    public Double getPrix() {
        return pizza.getPrix() + 3.00;
    }
}

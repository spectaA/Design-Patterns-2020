package prjPizzas;

public class Oignons extends PizzaToppings {

    public Oignons(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", oignons (2.50)";
    }

    @Override
    public Double getPrix() {
        return pizza.getPrix() + 2.5;
    }
}

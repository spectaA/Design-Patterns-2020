package prjPizzas;

public class Fromage extends PizzaToppings {

    public Fromage(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", fromage (2.5)";
    }

    @Override
    public Double getPrix() {
        return pizza.getPrix() + 2.5;
    }
}

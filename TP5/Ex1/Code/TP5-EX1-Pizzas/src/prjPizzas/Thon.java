package prjPizzas;

public class Thon extends PizzaToppings {

    public Thon(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", thon (3.00)";
    }

    @Override
    public Double getPrix() {
        return pizza.getPrix() + 3.00;
    }
}

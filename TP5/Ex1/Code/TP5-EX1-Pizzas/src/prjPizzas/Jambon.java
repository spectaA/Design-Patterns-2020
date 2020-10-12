package prjPizzas;

public class Jambon extends PizzaToppings {

    public Jambon(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", jambon (1.50)";
    }

    @Override
    public Double getPrix() {
        return pizza.getPrix() + 1.5;
    }
}

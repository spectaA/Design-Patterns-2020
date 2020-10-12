package prjPizzas;

public abstract class PizzaToppings implements Pizza {

    protected final Pizza pizza;

    public PizzaToppings(Pizza p) {
        this.pizza = p;
    }

    @Override
    public String getDescription() {
        return "Toppings";
    }

}

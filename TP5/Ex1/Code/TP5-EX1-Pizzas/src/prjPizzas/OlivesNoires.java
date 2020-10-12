package prjPizzas;

public class OlivesNoires extends PizzaToppings {

    public OlivesNoires(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", olives noires (4.50)";
    }

    @Override
    public Double getPrix() {
        return pizza.getPrix() + 4.5;
    }
}

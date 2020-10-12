package prjPizzas;

public class BoulettesDeViande extends PizzaToppings {

    public BoulettesDeViande(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", boulettes de viande (5.00)";
    }

    @Override
    public Double getPrix() {
        return pizza.getPrix() + 5.00;
    }
}

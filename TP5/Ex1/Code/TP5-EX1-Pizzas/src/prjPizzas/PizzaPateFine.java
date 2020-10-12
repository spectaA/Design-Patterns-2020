package prjPizzas;

public class PizzaPateFine implements Pizza {
    @Override
    public String getDescription() {
        return "Pizza pâte fine (8.50)";
    }

    @Override
    public Double getPrix() {
        return 8.5;
    }
}

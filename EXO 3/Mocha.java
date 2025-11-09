public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Chocolat";
    }

    public double cost() {
        return beverage.cost() + 0.20; // Ajoute le coût du chocolat
    }
}

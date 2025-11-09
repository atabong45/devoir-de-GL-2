public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Chantilly";
    }

    public double cost() {
        return beverage.cost() + 0.10; // Ajoute le coût de la chantilly
    }
}
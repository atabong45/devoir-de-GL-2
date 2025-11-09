public abstract class Beverage {
    String description = "Boisson inconnue";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
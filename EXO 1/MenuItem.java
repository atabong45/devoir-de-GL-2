// La Feuille (Leaf) : représente un élément de menu individuel.
public class MenuItem extends MenuComponent {
    String name;
    String description;
    boolean vegetarian;
    double price;

    // Constructeur : prend les données de l'élément de menu.
    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    // --- Surcharge des Méthodes d'Opération (celles qui ont du sens) ---

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }
    
    // Le print() de la Feuille imprime ses propres informations.
    @Override
    public void print() {
        System.out.print("  " + getName());
        if (isVegetarian()) {
            System.out.print(" (v)");
        }
        System.out.println(", " + getPrice() + "€");
        System.out.println("     -- " + getDescription());
    }
}
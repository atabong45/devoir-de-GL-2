import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Le Composite : représente un Menu qui peut contenir d'autres Menus (récursivité) ou MenuItems.
public class Menu extends MenuComponent {
    List<MenuComponent> menuComponents = new ArrayList<>();
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // --- Surcharge des Méthodes de Gestion (celles qui ont du sens pour un conteneur) ---

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }
    
    // Surcharge pour un Menu : il n'a pas de prix et n'est pas végétarien lui-même.
    @Override
    public double getPrice() {
        // Ajout d'une fonctionnalité : calculer le prix total du menu (somme des enfants)
        double total = 0.0;
        for (MenuComponent component : menuComponents) {
            // Utilise la récursivité pour obtenir le prix des sous-menus et des items.
            total += component.getPrice();
        }
        return total;
    }

    // --- Méthode d'Opération Clé : Print Récursif ---

    @Override
    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("------------------------------------");

        // --- Utilisation du CompositeIterator ---
        Iterator<MenuComponent> iterator = createIterator(); // Utilise la nouvelle méthode
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            // L'appel récursif est maintenant géré par l'itérateur lui-même
            if (menuComponent instanceof MenuItem) { // Ajout d'une condition pour ne pas imprimer les Menus deux fois
                menuComponent.print();
            }
        }
        
        // Ajout : Afficher le prix total du menu
        System.out.println("\n[Prix Total du " + getName() + ": " + getPrice() + "€]\n");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    // Surcharge du createIterator pour retourner l'itérateur de la liste interne
    @Override
    public Iterator<MenuComponent> createIterator() {
        // On crée un CompositeIterator en lui passant l'itérateur de la liste interne.
        // Il gérera le parcours de tout l'arbre descendant.
        return new CompositeIterator(menuComponents.iterator());
    }
}
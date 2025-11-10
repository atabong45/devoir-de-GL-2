import java.util.Iterator;

// Le Client : interagit avec tous les objets via l'interface MenuComponent
public class Waitress {
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    // Méthode standard pour imprimer tout le menu (utilise la récursivité du Composite)
    public void printMenu() {
        allMenus.print();
    }

    //  Méthode pour imprimer un composant spécifique (Menu ou MenuItem) ---
    public void printSpecificComponent(MenuComponent component) {
        System.out.println("--- AFFICHAGE DU COMPOSANT : " + component.getName() + " ---");
        component.print();
        System.out.println("------------------------------------");
    }

    //  Méthode pour obtenir le prix total d'un composant spécifique (Menu ou MenuItem) ---
    public void printSpecificComponentPrice(MenuComponent component) {
        System.out.println("--- PRIX TOTAL DE : " + component.getName() + " ---");
        System.out.println(component.getPrice() + "€");
        System.out.println("------------------------------------");
    }

    // Méthode pour imprimer UNIQUEMENT les non-végétariens ---
    public void printNonVegetarianMenu() {
        System.out.println("\nMENU NON-VÉGÉTARIEN\n--------------------");
        // Utilise l'itérateur récursif pour parcourir tous les éléments
        Iterator<MenuComponent> iterator = allMenus.createIterator();

        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            try {
                // Si c'est un MenuItem ET qu'il N'est PAS végétarien
                if (menuComponent instanceof MenuItem && !menuComponent.isVegetarian()) {
                    menuComponent.print();
                }
            } catch (UnsupportedOperationException ignored) {
                // Ignore les Composites (Menus) qui lèvent l'exception car ils ne sont ni l'un ni l'autre.
            }
        }
        System.out.println("--------------------\n");
    }

    // --- Méthode d'Exercice : Imprimer uniquement les plats Végétariens ---
    public void printVegetarianMenu() {
        System.out.println("\nMENU VÉGÉTARIEN\n--------------------");
        // Crée un itérateur pour parcourir l'arbre (le Menu de haut niveau)
        Iterator<MenuComponent> iterator = allMenus.createIterator();

        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            try {
                // Tente d'appeler isVegetarian() et print() sur l'élément.
                // Si c'est un MenuItem ET qu'il est végétarien, on l'imprime.
                if (menuComponent instanceof MenuItem && menuComponent.isVegetarian()) {
                    menuComponent.print();
                }
            } catch (UnsupportedOperationException e) {
                // CATCH : Si c'est un objet Menu (Composite), isVegetarian() lève une
                // UnsupportedOperationException. On l'attrape et on continue l'itération.
                // Cela garantit que seuls les MenuItems sont vérifiés.
            }
        }
        System.out.println("--------------------\n");
    }
}
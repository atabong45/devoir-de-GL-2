import java.util.Iterator;
import java.util.NoSuchElementException;

// La superclasse abstraite qui définit le contrat commun (Component)
public abstract class MenuComponent {

    // --- Méthodes de Gestion de Composants (Les Composites les surchargent) ---

    // Ajoute un composant à la collection. Par défaut, lève une exception (car les Feuilles ne supportent pas l'ajout).
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    // Supprime un composant de la collection. Par défaut, lève une exception.
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    // Récupère un enfant par son index. Par défaut, lève une exception.
    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }
    
    // Fournit un itérateur pour parcourir la structure (utile pour la serveuse).
    // Une implémentation par défaut simple pourrait retourner un itérateur vide pour les Feuilles.
    public Iterator<MenuComponent> createIterator() {
        // En Java, on peut retourner une implémentation anonyme d'Iterator pour une Feuille.
        return new Iterator<MenuComponent>() {
            @Override
            public boolean hasNext() { return false; }

            @Override
            public MenuComponent next() { throw new NoSuchElementException(); }
        };
    }

    // --- Méthodes d'Opération (Les Feuilles et Composites les surchargent) ---

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    // Affiche le composant (l'opération clé du Composite)
    public void print() {
        throw new UnsupportedOperationException();
    }
}
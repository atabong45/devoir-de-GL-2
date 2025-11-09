import java.util.Iterator;
import java.util.Stack;

// Le CompositeIterator : gère le parcours de l'arbre Composite
public class CompositeIterator implements Iterator<MenuComponent> {
    
    private Stack<Iterator<MenuComponent>> stack = new Stack<>();

    public CompositeIterator(Iterator<MenuComponent> iterator) {
        // Au début, on empile l'itérateur de l'élément racine (AllMenus)
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        // Tant que la pile n'est pas vide
        if (stack.empty()) {
            return false;
        }
        
        // Regarder l'itérateur courant au sommet de la pile
        Iterator<MenuComponent> iterator = stack.peek();
        
        // Si l'itérateur courant n'a plus d'éléments, on le dépile et on réessaye
        if (!iterator.hasNext()) {
            stack.pop();
            return hasNext(); // Appel récursif pour vérifier le prochain itérateur dans la pile
        } else {
            return true; // L'itérateur courant a un élément suivant
        }
    }

    @Override
    public MenuComponent next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        
        // Récupère l'élément suivant de l'itérateur courant
        Iterator<MenuComponent> iterator = stack.peek();
        MenuComponent component = iterator.next();

        // Si l'élément suivant est un Composite (un Menu), on empile son itérateur.
        // C'est ce qui gère le parcours en profondeur.
        if (component instanceof Menu) {
            stack.push(component.createIterator());
        }
        
        // Retourne l'élément Leaf ou Composite trouvé
        return component;
    }

    // On n'implémente pas remove() pour ce cas
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

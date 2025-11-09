public class StarbuzzCoffee {

    public static void main(String args[]) {
        // Scénario 1 : Un Espresso simple, sans suppléments.
        Beverage beverage1 = new Espresso();
        System.out.println("Commande 1:");
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());
        System.out.println("--------------------");

        // Scénario 2 : Un Café Corsé avec double Chocolat et une touche de Chantilly.
        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2); // On enveloppe le café avec du chocolat
        beverage2 = new Mocha(beverage2); // On enveloppe une deuxième fois pour un double chocolat
        beverage2 = new Whip(beverage2);  // On ajoute la chantilly
        System.out.println("Commande 2:");
        System.out.println(beverage2.getDescription() + " $" + String.format("%.2f", beverage2.cost()));
        System.out.println("--------------------");

        // Scénario 3 : Un Mélange Maison avec Soja, Chocolat et Chantilly.
        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);      // On enveloppe avec du Soja
        beverage3 = new Mocha(beverage3);    // Puis du Chocolat
        beverage3 = new Whip(beverage3);     // Et enfin de la Chantilly
        System.out.println("Commande 3:");
        System.out.println(beverage3.getDescription() + " $" + String.format("%.2f", beverage3.cost()));
        System.out.println("--------------------");
    }
}
public class Main {
    public static void main(String[] args) {
        // --- 1. CRÉATION DES FEUILLES (MenuItems) ---

        MenuItem pancakeBreakfast = new MenuItem(
            "Petit-déjeuner Pancake",
            "Pancakes avec œufs brouillés et toast",
            false,
            2.99
        );

        MenuItem waffle = new MenuItem(
            "Gaufres régulières",
            "Nos gaufres avec vos baies préférées",
            true,
            3.59
        );

        MenuItem veggieBurger = new MenuItem(
            "Burger Végétarien",
            "Burger végétarien sur un pain de blé entier",
            true,
            3.99
        );
        
        MenuItem soupOfTheDay = new MenuItem(
            "Soupe du Jour",
            "Une soupe du jour, servie avec un accompagnement de salade",
            true,
            1.59
        );

        MenuItem pie = new MenuItem("Tarte aux pommes", "Tarte aux pommes avec glace", false, 1.50);
        MenuItem fruitSalad = new MenuItem("Salade de fruits", "Salade de fruits frais de saison", true, 2.50);
        
        // --- 2. CRÉATION DES COMPOSITES (Menus) ---
        
        Menu pancakeHouseMenu = new Menu("Menu Pancake House", "Petits-déjeuners");
        Menu dinerMenu = new Menu("Menu du Diner", "Déjeuner et Diner");
        Menu cafeMenu = new Menu("Menu du Café", "Diners");
        Menu dessertMenu = new Menu("Menu Desserts", "Desserts succulents"); // Sous-menu

        // --- 3. CRÉATION DE L'ARBRE (Composite) ---
        
        Menu allMenus = new Menu("MENU GÉNÉRAL", "Tous les menus combinés");
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        // Ajout des éléments du Pancake House
        pancakeHouseMenu.add(pancakeBreakfast);
        pancakeHouseMenu.add(waffle);

        // Ajout des éléments du Diner (et d'un sous-menu)
        dinerMenu.add(veggieBurger);
        dinerMenu.add(soupOfTheDay);
        dinerMenu.add(dessertMenu); // Ajout d'un Composite (récursivité)
        
        // Ajout des éléments du Dessert
        dessertMenu.add(pie);
        dessertMenu.add(fruitSalad);
        
        // --- 4. EXÉCUTION (Client) ---
        
        Waitress waitress = new Waitress(allMenus);
        
        System.out.println("=========================================");
        System.out.println("OPÉRATION 1 : IMPRESSION COMPLÈTE DU MENU");
        System.out.println("=========================================");
        waitress.printMenu();
        
        System.out.println("============================================");
        System.out.println("OPÉRATION 2 : RECHERCHE VÉGÉTARIENNE (EXERCICE)");
        System.out.println("============================================");
        waitress.printVegetarianMenu();

        System.out.println("============================================");
        System.out.println("OPÉRATION 3 : Impression d'un sous-menu spécifique (Composite)");
        System.out.println("============================================");
        waitress.printSpecificComponent(dinerMenu);

        System.out.println("============================================");
        System.out.println("OPÉRATION 4 : Prix total d'un sous-menu spécifique (Composite)");
        System.out.println("============================================");
        waitress.printSpecificComponentPrice(dessertMenu);

        System.out.println("============================================");
        System.out.println("OPÉRATION 5 : Prix d'un élément de menu en particulier (Leaf)");
        System.out.println("============================================");
        waitress.printSpecificComponentPrice(pancakeBreakfast);
    }
}
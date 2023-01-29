package programmering.projekt1;

import java.util.ArrayList;
import java.util.List;
import static programmering.projekt1.Main.scanner;

public class Shop {

    public List<Weapon> shopWeapons = new ArrayList<>();
    public List<Consumable> shopItems = new ArrayList<>();

    public int shop() {
        System.out.println("Weolcome to the shop. Here you can buy Weapons and Potions!");
        System.out.println("What do you want to buy");
        System.out.println("1. Weapons");
        System.out.println("2. Items");
        System.out.println("3. Leave");
        int cost = 0;
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.println("You have " + );
                for (int y = 0; y < shopWeapons.size(); y++) {
                    System.out.println(y + 1 + shopWeapons.get(y).name + ". " + shopWeapons.get(y).description);
                    System.out.println("It deals " + shopWeapons.get(y).damage + ". Cost: " + shopWeapons.get(y).price);
                }
                int weaponChoice = scanner.nextInt();
                cost = shopWeapons.get(weaponChoice - 1).price;
            }
            case 2 -> {
                for (int y = 0; y < shopItems.size(); y++){
                    
                    System.out.println(y + 1 + shopItems.get(y).name + ". " + shopItems.get(y).description);
                    System.out.println("It");
                }
            }
            case 3 -> {
                break;
            }

        }
        return cost;
    }
}

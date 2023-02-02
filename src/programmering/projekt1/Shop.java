package programmering.projekt1;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    public List<Weapon> shopWeapons = new ArrayList<>();
    public List<Consumable> shopConsumables = new ArrayList<>();

    public int shop(int gold, List<Weapon> weapons, List<Consumable> consumables) {
        System.out.println("Welcome to the shop. Here you can buy Weapons and Potions!");
        System.out.println("What do you want to buy");
        System.out.println("You have " + gold + " gold");
        System.out.println("1. Weapons");
        System.out.println("2. Potions");
        System.out.println("3. Leave");
        int cost = 0;
        int choice = Main.scanInt();

        switch (choice) {
            case 1 -> {
                for (int y = 0; y < shopWeapons.size(); y++) {
                    System.out.println(y + 1 + ". " + shopWeapons.get(y).name + ". " + shopWeapons.get(y).description);
                    System.out.println("It deals " + shopWeapons.get(y).damage + ". Cost: " + shopWeapons.get(y).price);
                }
                System.out.println(shopWeapons.size() + 1 + ". Leave");
                int weaponChoice;
                do {
                    weaponChoice = Main.scanInt();
                } while (weaponChoice < 1 || weaponChoice > (shopWeapons.size() + 1));
                if (weaponChoice == shopWeapons.size() + 1) {
                    return 0;
                }

                cost = shopWeapons.get(weaponChoice - 1).price;
                if (cost <= gold) {
                    weapons.add(shopWeapons.get(weaponChoice - 1));
                } else {
                    System.out.println("You can't afford that!");
                    cost = 0;
                }
            }
            case 2 -> {
                for (int y = 0; y < shopConsumables.size(); y++) {
                    System.out.println(y + 1 + ". " + shopConsumables.get(y).name + ". " + shopConsumables.get(y).description);
                    if (shopConsumables.get(y).healing) {
                        System.out.println("It heals " + shopConsumables.get(y).potency + " HP" + ". Cost: " + shopWeapons.get(y).price);
                    } else {
                        System.out.println("It gives " + shopConsumables.get(y).potency + " attack damage buff" + ". Cost: " + shopWeapons.get(y).price);
                    }
                }
                System.out.println(shopConsumables.size() + 1 + ". Leave");

                int consumableChoice;
                do {
                    consumableChoice = Main.scanInt();
                } while (consumableChoice < 1 || consumableChoice > (shopConsumables.size() + 1));
                if (consumableChoice == shopConsumables.size() + 1) {
                    return 0;
                }
                cost = shopConsumables.get(consumableChoice - 1).price;
                if (cost < gold) {
                    consumables.add(shopConsumables.get(consumableChoice - 1));
                } else {
                    System.out.println("You can't afford that!");
                    cost = 0;
                }

            }
            case 3 -> {
                break;
            }

        }
        return cost;
    }
}
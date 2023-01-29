package programmering.projekt1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static boolean map = true;
    public static boolean shop = false;
    public static Scanner scanner = new Scanner(System.in);

    public static boolean fight(Room position, List<Weapon> weapons, List<Consumable> consumables, int playerHP) {

        while (true) {
            boolean monster = position.hasMonster();
            boolean turn = true;
            if (monster) {
                if (turn) {
                    System.out.println("A monster stands in your way. You need to kill it to proceed");
                    System.out.println("You have " + playerHP + " health");
                    System.out.println("You are fighting " + position.mob.printInfo());
                    System.out.println("What action do you want to take");
                    System.out.println("1. attack");
                    System.out.println("2. item");
                    System.out.println("3. info");
                    var choice = scanner.nextInt();
                    switch (choice) {
                        case 1 -> {
                            System.out.println("You chose to attack");
                            System.out.println("Choose your weapon!!!");
                            for (int y = 0; y < weapons.size(); y++) {
                                String weaponName = weapons.get(y).getName();
                                int weaponDamage = weapons.get(y).getDmg();
                                System.out.println((y + 1) + ". " + weaponName + ". It deals " + weaponDamage + " damage");
                            }

                            int weaponChoice;
                            do {
                                weaponChoice = scanner.nextInt();

                            } while (weaponChoice < 1 || weaponChoice > (weapons.size() + 1));

                            position.mob.hp = position.mob.hp - weapons.get(weaponChoice).getDmg();

                            if (position.mob.hp > 0) {
                                System.out.println(position.mob.name +" is dead!");
                                turn = false;
                                position.mob = null;
                            }

                        }
                        case 2 -> {
                            for (int y = 0; y < consumables.size(); y++) {
                                String itemName = consumables.get(y).getName();
                                System.out.println((y + 1) + ". " + itemName + ".");
                            }
                        }
                        case 3 -> {
                            position.mob.printInfo();
                        }
                    }

                } else {
                    playerHP = playerHP - position.mob.ap;

                    if (playerHP > 0) {
                        turn = true;
                    }
                }
                if (playerHP <= 0) {
                    System.out.println("You died");
                    return false; // You are dead. skriv ut det
                }
                if (position.mob == null) {
                    System.out.println("All the monsters have perished. You may now pass.");
                    return true; // Winning. Stoppa in eventuella vapen och cunsumables som monstren hade i weapons och consumables

                }
            }

        }

    }

    public static void main(String[] args) {

        var myMap = new Map();
        var position = myMap.rooms.get(0);

        List<Weapon> weapons = new ArrayList<>();
        List<Consumable> consumables = new ArrayList<>();
        List<Key> keys = new ArrayList<>();
        int gold = 0;

        Weapon fist = new Weapon("Fist", "It's your fist. Sure to hurt your hand as much as it hurts whatever you're punching", 1, 0);
        weapons.add(fist);

        int playerHP = 10;

        while (map) {
            System.out.println("===========");
            position.look();
            System.out.println("1. Leave");
            System.out.println("2. Search");
            System.out.println("3. Inventory");
            System.out.println("4. Shop");

            var choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    position = position.leave(keys);
                    if (position.hasMonster()) {
                        if (!fight(position, weapons, consumables, playerHP)) {
                            map = false;
                        }
                    }

                }

                case 2 -> {
                    position.searchWeapon(weapons);
                    position.searchConsumable(consumables);
                    position.searchKey(keys);
                    gold = position.SearchGold();

                }
                case 3 -> {
                    System.out.println("1. Weapons");
                    System.out.println("2. Consumables");
                    System.out.println("3. Keys");
                    System.out.println("4. Back");
                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1 -> {
                            for (int i = 0; i < weapons.size(); i++) {
                                Weapon myWeapon = weapons.get(i);
                                System.out.print((i + 1) + ": ");
                                System.out.println(myWeapon.name);
                            }
                        }
                        case 2 -> {
                            for (int i = 0; i < consumables.size(); i++) {
                                Consumable myConsumable = consumables.get(i);
                                System.out.print((i + 1) + ": ");
                                System.out.println(myConsumable.name);

                            }

                        }
                        case 3 -> {
                            for (int i = 0; i < keys.size(); i++) {
                                Key myKey = keys.get(i);
                                System.out.print((i + 1) + ": ");
                                System.out.println(myKey.name);
                            }
                        }
                        case 4 -> {
                            break;
                        }
                    }

                }

                case 4 -> {
                }
            }

        }

    }

}

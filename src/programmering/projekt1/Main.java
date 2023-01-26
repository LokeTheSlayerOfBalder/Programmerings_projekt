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
            int monsters = position.mobs.size();
            boolean turn = true;
            if (monsters >= 1) {
                if (turn) {
                    System.out.println("What action do you want to take");
                    System.out.println("1. attack");
                    System.out.println("2. item");
                    System.out.println("3. info");
                    var choice = scanner.nextInt();
                    switch (choice) {
                        case 1 -> {

                        }
                        case 2 -> {

                        }
                        case 3 -> {

                        }
                    }
                }
            }
            if (playerHP <= 0) {
                System.out.println("You died");
                return false; // You are dead. skriv ut det
            }
            if (position.mobs.size() == 0) {
                return true; // Winning. Stoppa in eventuella vapen och cunsumables som monstren hade i weapons och consumables

            }
        }

    }

    public static void main(String[] args) {

        var myMap = new Map();

        var position = myMap.rooms.get(0);

        List<Weapon> weapons = new ArrayList<>();
        List<Consumable> consumables = new ArrayList<>();
        List<Key> keys = new ArrayList<>();

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
                        fight(position, weapons, consumables, playerHP);
                    }

                }

                case 2 -> {
                    position.searchWeapon(weapons);
                    position.searchConsumable(consumables);
                    position.searchKey(keys);

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

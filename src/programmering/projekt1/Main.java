package programmering.projekt1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static boolean map = true;
    public static boolean fight = false;
    public static boolean shop = false;

    public static void main(String[] args) {

        var scanner = new Scanner(System.in);

        var myMap = new Map();

        var position = myMap.rooms.get(0);

        List<Weapon> weapons = new ArrayList<>();
        List<Consumable> consumables = new ArrayList<>();
        List<Key> keys = new ArrayList<>();

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
    private List<Weapon> weapons;
    private List<Consumable> consumables;

}

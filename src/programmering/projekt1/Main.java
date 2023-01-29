package programmering.projekt1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static boolean map = true;
    public static boolean shop = false;
    public static Scanner scanner = new Scanner(System.in);

    public static boolean fight(Room position, List<Weapon> weapons, List<Consumable> consumables, int playerHP) {

        int attackBuff = 0;
        playerHP = 10;
        boolean turn = true;
        while (true) {
            boolean monster = position.hasMonster();
            if (monster) {

                if (turn) {
                    System.out.println("===========");
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
                            System.out.println("===========");
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

                            } while (weaponChoice < 1 || weaponChoice > weapons.size());

                            position.mob.hp = position.mob.hp - weapons.get(weaponChoice - 1).getDmg();
                            position.mob.hp = position.mob.hp - attackBuff;
                            attackBuff = 0;

                            if (position.mob.hp <= 0) {
                                System.out.println(position.mob.name + " is dead!");
                                turn = false;
                                position.mob = null;
                            } else {
                                System.out.println("The enemy survived with " + position.mob.hp);
                                turn = false;
                            }

                        }
                        case 2 -> {
                            System.out.println("===========");
                            for (int y = 0; y < consumables.size(); y++) {
                                String itemName = consumables.get(y).getName();
                                System.out.println((y + 1) + ". " + itemName + ".");
                                if (consumables.get(y).healing == true) {
                                    System.out.println("It will heal you for " + consumables.get(y).potency + "health.");
                                } else {
                                    System.out.println("It will make your next attack deal " + consumables.get(y).potency + " additional damage.");
                                }

                            }
                            int itemChoice;
                            do {
                                itemChoice = scanner.nextInt();
                            } while (itemChoice < 1 || itemChoice > consumables.size());

                            if (consumables.get(itemChoice).healing == true) {
                                playerHP = playerHP + consumables.get(itemChoice).potency;
                            } else {
                                attackBuff = consumables.get(itemChoice).potency;
                            }
                        }
                        case 3 -> {
                            position.mob.printInfo();
                        }
                    }

                }

             else {
                playerHP = playerHP - position.mob.ap;
            System.out.println("===========");

                System.out.println("You take " + position.mob.ap + " damage.");
                System.out.println("You have " + playerHP + " health left.");
                System.out.println("===========");

                if (playerHP > 0) {
                    turn = true;
                }
            }
            if (playerHP <= 0) {
                System.out.println("You died");
                map = false;
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

        System.out.println("The game will ask you what you want to do by printing out alternatives such as attack, leave, shop, or items.");
        System.out.println("These alternatives will have a corresponding number. Enter one of these number to preform this action.");

        System.out.println("Welcome to the game. As you enter you will need to explore and battle through this abandoned house.");
        System.out.println("Years before these grounds were subject to many satanic rituals leaving the lands haunted by inholy beings.");
        System.out.println("You have been sent here by the Anti Satatnic Situations Federation Central to Korea (A.S.S.F.C.K) to asses and neutralise the unholy hellspawns");
        System.out.println("There have been reports of a fallen angel, a betrayer of god, guarding a powerfull relic. We suggest you find it.");
        System.out.println("May the force be with you, soldier!");

        var myMap = new Map();
        var position = myMap.rooms.get(0);

        List<Weapon> weapons = new ArrayList<>();
        List<Consumable> consumables = new ArrayList<>();
        List<Key> keys = new ArrayList<>();
        int gold = 0;

        Weapon fist = new Weapon("Your Fists", "It's your fist. Sure to hurt your hand as much as it hurts whatever you're punching", 1, 0);
        weapons.add(fist);

        int playerHP = 0;

        while (map) {
            position.look();
            System.out.println("===========");
            System.out.println("1. Leave");
            System.out.println("2. Search");
            System.out.println("3. Inventory");
            System.out.println("4. Shop");
            System.out.println("===========");

            var choice = scanner.nextInt();

            System.out.println("===========");

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
                    gold = gold + position.SearchGold();
                    System.out.println("===========");

                }
                case 3 -> {
                    System.out.println("You have " + gold + " gold.");
                    System.out.println("1. Weapons");
                    System.out.println("2. Items");
                    System.out.println("3. Keys");
                    System.out.println("4. Back");
                    System.out.println("===========");
                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1 -> {
                            if (weapons.size() > 0) {
                                for (int i = 0; i < weapons.size(); i++) {
                                    Weapon myWeapon = weapons.get(i);
                                    System.out.print((i + 1) + ": ");
                                    System.out.println(myWeapon.name + ". It deals " + myWeapon.damage + "damage.");
                                }
                                System.out.println("===========");
                            } else {
                                System.out.println("You have no weapons.");
                                System.out.println("===========");
                            }

                        }
                        case 2 -> {
                            if (consumables.size() > 0) {
                                for (int i = 0; i < consumables.size(); i++) {
                                    Consumable myConsumable = consumables.get(i);
                                    System.out.print((i + 1) + ": ");
                                    System.out.println(myConsumable.name);
                                    if (myConsumable.healing == true) {
                                        System.out.println("It heals you for " + myConsumable.potency + " health.");
                                    } else {
                                        System.out.println("It your next attacks damage with " + myConsumable.potency + " damage.");
                                    }

                                }
                                System.out.println("===========");
                            } else {
                                System.out.println("You have no items");
                                System.out.println("===========");
                            }

                        }
                        case 3 -> {
                            if (keys.size() > 0) {
                                for (int i = 0; i < keys.size(); i++) {
                                    Key myKey = keys.get(i);
                                    System.out.print((i + 1) + ": ");
                                    System.out.println(myKey.name);
                                }
                                System.out.println("===========");
                            } else {
                                System.out.println("You have no keys.");
                                System.out.println("===========");
                            }

                        }
                        case 4 -> {
                            break;
                        }
                    }

                }

                case 4 -> {
                    gold = gold - myMap.shop.shop(gold, weapons, consumables);
                }
            }

        }

    }

    public Main() {

    }

}

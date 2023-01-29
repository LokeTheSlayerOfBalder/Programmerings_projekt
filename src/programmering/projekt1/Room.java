package programmering.projekt1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import programmering.projekt1.Map.DIRECTION;

public class Room {

    private Scanner scanner = new Scanner(System.in);
    public String name;
    public String description;
    public Connection[] connections = new Connection[4];
    public List<Weapon> weapons = new ArrayList<>();
    public List<Consumable> consumables = new ArrayList<>();
    public List<Key> keys = new ArrayList<>();
    public int gold = 0;
    public Mob mob;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void connect(DIRECTION dir, Connection connection, Room room) {
        this.connections[dir.ordinal()] = connection;
        connection.side1 = this;
        connection.side2 = room;
        room.connections[dir.getOpSide().ordinal()] = connection;
    }

    public void look() {
        System.out.println(this.name);
        System.out.println(this.description);
    }

    public Room leave(List<Key> keys) {
        while (true) {
            var choiceMax = 1;
            for (var i = 0; i < Map.DIRECTION.values().length; i++) {
                if (this.connections[i] != null) {
                    System.out.println(choiceMax++ + ". Move: " + Map.DIRECTION.values()[i].toString());

                }
            }
            System.out.println(choiceMax + ". Cancel");
            System.out.println("===========");
            var choice = scanner.nextInt();
            System.out.println("===========");


            if (choice == choiceMax) {
                return this;
            } else if (choice < this.connections.length + 1) {
                var connectionnr = -1;
                for (var i = 0; i < choice; i++) {
                    connectionnr++;
                    while (this.connections[connectionnr] == null) {
                        connectionnr++;
                    }
                }
                return this.connections[connectionnr].moveThrough(this, keys);
            }
        }
    }

    public void searchWeapon(List<Weapon> weapons) {
        if (this.weapons.size() > 0) {
            System.out.println("You have found weapon/s");
            for (Weapon weapon : this.weapons) {
                System.out.println(" ");
                System.out.println("You have found " + weapon.name + ". It has a damage stat of: " + weapon.damage);
                System.out.println(weapon.description);
                weapons.add(weapon);

            }
            this.weapons.clear();
        } else {
            System.out.println("You found no weapons.");
        }
    }

    public void searchConsumable(List<Consumable> consumables) {
        if (this.consumables.size() > 0) {
            System.out.println("You have found item/s");
            for (Consumable consumable : this.consumables) {
                System.out.println(" ");
                System.out.println("You have found " + consumable.name);
                System.out.println(consumable.description);
                consumables.add(consumable);
            }
            this.consumables.clear();

        } else {
            System.out.println("You found no items.");
        }
    }

    public void searchKey(List<Key> keys) {
        if (this.keys.size() > 0) {
            System.out.println("You have found key/s");
            for (Key key : this.keys) {
                System.out.println(" ");
                System.out.println("You have found " + key.name + ". It's a key.");
                System.out.println(key.description);
                System.out.println("I wonder wich door it can open");
                keys.add(key);
            }
            this.keys.clear();
        } else {
            System.out.println("You found no keys");
        }
    }

    public int SearchGold() {
        if (gold > 0) {
            System.out.println("You have found " + gold + " gold.");
        } else {
            System.out.println("You found no gold.");
        }
        gold = 0;
        return gold;
    }

    public boolean hasMonster() {
        return this.mob != null;
    }

}
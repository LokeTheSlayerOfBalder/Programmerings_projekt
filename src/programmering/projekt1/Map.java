package programmering.projekt1;

import java.util.ArrayList;
import java.util.List;

public class Map {

    public enum DIRECTION {
        North,
        South,
        East,
        West;
        public DIRECTION getOpSide() {
            switch (this) {
                case North -> {
                    return South;
                }
                case South -> {
                    return North;
                }
                case East -> {
                    return West;
                }
                default  -> {
                    return East;
                }
            }
        }
    }
    
    
    List<Room> rooms = new ArrayList<>();

    public Map() {
        this.rooms.add(new Room("start", "Old shed"));
        this.rooms.add(new Room("room1", "Prettier but still shed-like"));
        this.rooms.add(new Room("room1-key", "More shed-like than the previous room but nothing compared to the first"));
        this.rooms.add(new Room("room2", "Looks baroque"));
        this.rooms.add(new Room("room3", "A long, looming corridor"));
        this.rooms.add(new Room("big room", "A massive hall."));
        this.rooms.add(new Room("room4", "feels small after seeing the hall"));
        this.rooms.add(new Room("room5", "feels small after seeing the hall"));
        
        this.rooms.get(0).connect(DIRECTION.East, new Connection(), this.rooms.get(1));
        this.rooms.get(1).connect(DIRECTION.North, new Connection(), this.rooms.get(2));
        this.rooms.get(1).connect(DIRECTION.East, new Connection(), this.rooms.get(3));
        this.rooms.get(3).connect(DIRECTION.South, new Connection(), this.rooms.get(4));
        this.rooms.get(4).connect(DIRECTION.South, new Connection(), this.rooms.get(5));
        this.rooms.get(5).connect(DIRECTION.South, new Connection(), this.rooms.get(6));
        this.rooms.get(5).connect(DIRECTION.South, new Connection(), this.rooms.get(7));
        
        
        var magicSword = new Weapon("Buttocks", "The sword is brown and stinky", 1);
        this.rooms.get(0).weapons.add(magicSword);
        
        var meatStick = new Weapon("Axels schlong","It'r quite small", 0);
        this.rooms.get(0).weapons.add(meatStick);
        
        var magicPotion = new Consumable("pissjar", "A jar of magic piss... i think");
        this.rooms.get(0).consumables.add(magicPotion);
        
        var bigMonster = new Mob("Bigboi","He is a very big boi!", 6, 1);
        this.rooms.get(3).mobs.add(bigMonster);
        
        var goldenKey = new Key("Golden Key", "This key looks golden but it's just made of chocolate");
        var door = new Door();
        door.key = goldenKey;
        this.rooms.get(2).keys.add(goldenKey);
        
        this.rooms.get(4).connect(DIRECTION.South, door, this.rooms.get(5));
        this.rooms.get(5).connect(DIRECTION.South, new Connection(), this.rooms.get(6));
        this.rooms.get(5).connect(DIRECTION.East, new Connection(), this.rooms.get(7));
        
    }
}
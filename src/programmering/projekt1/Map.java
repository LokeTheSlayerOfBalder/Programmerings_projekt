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
                default -> {
                    return East;
                }
            }
        }
    }

    List<Room> rooms = new ArrayList<>();
    Shop shop = new Shop();

    public Map() {
        this.rooms.add(new Room("This is an old shed. There is a text on the ground. It says `Start room`", "East of you is a much prettier room"));
        //room 0
        this.rooms.add(new Room("This room wasn't to much pretier actually. It's just a not quite as rotten shed", "There is another shed-ish room to the north and one with carpets to the east. The first room is back west."));
        //room 1
        this.rooms.add(new Room("This is a new shed. fresh paint and everything", "The only way out is back south to the slightly worn shed"));
        //room 2
        this.rooms.add(new Room("This room is giving Mozart vibes", "There is a hallway to the south. It's a very long hallway. The slightly worn shed is back west"));
        //room 3
        this.rooms.add(new Room("This corridor is so long it's kinda offputting", "At the end of the corridor there is a big door with a  big lock. I'm gonna need a key. The previous room is north of here."));
        //room 4
        this.rooms.add(new Room("Wow, This room is incredibly big. Like football stadium big", "There are three doors. To the south, to the east, and back north to the corridor."));
        //room 5
        this.rooms.add(new Room("This room is foggy. Not `creepy` foggy. More like a `heaven` foggy", "There is a door leading south and one leading north to the big room"));
        //room 6
        this.rooms.add(new Room("This room looks like hell. Literally, with fire and brimstone even.", "I can sense a great power through the locked door to the east. Am i really ready for what lies ahead?"));
        //room 7
        this.rooms.add(new Room("This room is terrifying. Chills run upp my spine and my body freezes in here", "I want my mommy!"));
        //room 8
        this.rooms.add(new Room("The fog is growing thicker. And... more pleasant. ", "There is one door to the south, one to the west, and one leading back north."));
        //room 9
        this.rooms.add(new Room("The fog is not as thick in here. It smells like there is a key in here. but where is it?", "The only way out of this room is back east"));
        //room 10
        this.rooms.add(new Room("With the fog getting as thick as possible you can barely make out anything. ", "There is a door leading even further south. There is also one leading back north"));
        //room 11
        this.rooms.add(new Room("This room reaks of heaven. The corpse of the angel is laying on the ground ", "There is a southern door that says armory. I wonder what i can find in there. I can also go back north"));
        //room 12
        this.rooms.add(new Room("The armory is dusty. Most of the heavenly weapons and relics are broken. Wonder what i can find in here. ", "The only door leads back north. "));
        //room 13

        this.rooms.get(0).connect(DIRECTION.East, new Connection(), this.rooms.get(1));
        this.rooms.get(1).connect(DIRECTION.North, new Connection(), this.rooms.get(2));
        this.rooms.get(1).connect(DIRECTION.East, new Connection(), this.rooms.get(3));
        this.rooms.get(3).connect(DIRECTION.South, new Connection(), this.rooms.get(4));
        this.rooms.get(5).connect(DIRECTION.South, new Connection(), this.rooms.get(6));
        this.rooms.get(5).connect(DIRECTION.East, new Connection(), this.rooms.get(7));
        this.rooms.get(6).connect(DIRECTION.South, new Connection(), this.rooms.get(9));
        this.rooms.get(9).connect(DIRECTION.West, new Connection(), this.rooms.get(10));
        this.rooms.get(9).connect(DIRECTION.South, new Connection(), this.rooms.get(11));
        this.rooms.get(11).connect(DIRECTION.South, new Connection(), this.rooms.get(12));
        this.rooms.get(12).connect(DIRECTION.South, new Connection(), this.rooms.get(13));

        var goldenKey = new Key("Golden Key", "This key looks golden but it's just made of chocolate");
        var goldenDoor = new Door();
        goldenDoor.key = goldenKey;
        this.rooms.get(2).keys.add(goldenKey);

        this.rooms.get(4).connect(DIRECTION.South, goldenDoor, this.rooms.get(5));

        var fireKey = new Key("Fire Key", "This key is hot to the touch. It seems to be made of hell itself");
        var fireDoor = new Door();
        fireDoor.key = fireKey;
        this.rooms.get(10).keys.add(fireKey);
        
        this.rooms.get(7).connect(DIRECTION.East, fireDoor, this.rooms.get(8));
        
        
        var superSoaker = new Weapon("Gun", "A gun of plastic. It shots water. At least i think it's water", 2, 0);
        this.rooms.get(1).weapons.add(superSoaker);
        var magicSword = new Weapon("Buttocks", "The sword is brown and stinky", 1, 0);
        this.rooms.get(3).weapons.add(magicSword);
        var meatStick = new Weapon("Axels schlong", "It'r quite small", 0, 0);
        this.rooms.get(2).weapons.add(meatStick);
        var superWeapon = new Weapon("Excalibur", "This mighty sword eminates powerfull energy.", 8, 0);
        this.rooms.get(13).weapons.add(superWeapon);
        
        this.rooms.get(5).gold = 60;
        this.rooms.get(10).gold = 80;
        this.rooms.get(12).gold = 150;
        this.rooms.get(13).gold = 200;
        
        var firstMonster = new Mob("Bigboi", "He is a very big boi!", 6, 1);
        this.rooms.get(4).mob = firstMonster;
        this.rooms.get(4).gold = 30;
        var secondMonster = new Mob("Slenderman", "This monster is very tall and skinny", 4, 3);
        this.rooms.get(6).mob = secondMonster;
        this.rooms.get(6).gold = 50;
        var fallenAngel = new Mob("Hephestus the fallen", "This is the fallen angel the breifing warned me about.", 13, 4);
        this.rooms.get(12).mob = fallenAngel;
        var cultistLeader = new Mob("Jeffrey", "The leader of the cult. The one who caused all of this heresy and mayhem", 300, 200);
        var bigSword = new Weapon("Greatsword", "Made out of Great iron. Hence the name Greatsword", 4, 50);
        this.shop.shopWeapons.add(bigSword);
        var uselessSpoon = new Weapon("Spoon", "An old rusty spoon.", 1, 25);
        this.shop.shopWeapons.add(uselessSpoon);
        var butterKnife = new Weapon("Butterknife", "Not a very big knife. Not very sharp either.", 2, 30);
        this.shop.shopWeapons.add(butterKnife);
        var paperSword = new Weapon("Paper sword", "This sword is made out of paper. Why would anyone buy this? Me, i would" ,0, 10);
        this.shop.shopWeapons.add(paperSword);
        
        
        var grogg = new Consumable("A pint of grogg", "A glass jar full of something that smells of alcohol", 1, true, -1);
        this.shop.shopConsumables.add(grogg);
        var steroid = new Consumable("D-Bal Max", "The most powerfull steroid on the market.", 100, false, 100);
        this.shop.shopConsumables.add(steroid);
        var weaknessPotion = new Consumable("Weakness", "It literally reduces your AD. Don't use it.", 1, false, 11);
        this.shop.shopConsumables.add(weaknessPotion);
        var magicPotion = new Consumable("pissjar", "A jar of magic piss... i think", 0, true, 3);
        this.rooms.get(3).consumables.add(magicPotion);
        var superHealth = new Consumable("Ironskin potion", "A potion that makes your skin hard as iron.", 0, true, 1000);
        this.rooms.get(13).consumables.add(superHealth);
        

    }
}
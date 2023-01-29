package programmering.projekt1;

import java.util.List;

public class Door extends Connection {

    public Key key;

    @Override
    public Room moveThrough(Room from, List<Key> keys) {
        if (keys.contains(this.key)) {
            System.out.println("You use " + this.key.name + " to open the door");
            return super.moveThrough(from, keys);
        }
        System.out.println("You need a key to open this door");
        System.out.println("===========");

        return from;
    }
}

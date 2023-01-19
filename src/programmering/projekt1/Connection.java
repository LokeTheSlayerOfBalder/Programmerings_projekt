package programmering.projekt1;

import java.util.List;

public class Connection {

    public Room side1;
    public Room side2;

    public Room moveThrough(Room from, List<Key> keys) {
        if (from == this.side1) {
            return this.side2;
        }
        if (from == this.side2) {
            return this.side1;
        }

        return from;
    }
}

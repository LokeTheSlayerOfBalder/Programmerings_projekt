package programmering.projekt1;

public class Mob {

    public String name;
    public String description;
    public int hp;
    public int ap;

    public Mob(String name, String description, int hp, int ap) {
        this.name = name;
        this.description = description;
        this.hp = hp;
        this.ap = ap;
    }

    public String printInfo() {
        String mobInfo = (name + ", " + description + ", It has an HP of " + hp + " and an AP of " + ap);
        return mobInfo;
    }
}
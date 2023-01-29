package programmering.projekt1;

public class Weapon {
    public String name;
    public String description;
    public int damage;
    public int price;
    
    public Weapon(String name, String description, int damage, int price) {
        this.name = name;
        this.description = description;
        this.damage = damage;
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public int getDmg(){
        return damage;
    }
}
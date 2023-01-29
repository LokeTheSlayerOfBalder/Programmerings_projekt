package programmering.projekt1;

public class Consumable {
    public String name;
    public String description;
    public int price;
    public boolean healing; 
    //public boolean healing säger om den ska heala eller ge en attack buff
    public int potency;
    
    public Consumable(String name, String description, int price, boolean healing, int potency){
        this.name = name;
        this.description = description;
        this.price = price;
        this.healing = healing;
        this.potency = potency;
    }
    public String getName(){
        return name;
    }
}

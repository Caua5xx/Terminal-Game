package items;

public class Potion {

    private String potionName;
    private String potionType;
    private int potionPrice;
    private int potionHealHealth;

    public Potion(String potionName, String potionType, int potionHealHealth, int potionPrice) {
        this.potionName = potionName;
        this.potionType = potionType;
        this.potionHealHealth = potionHealHealth;
        this.potionPrice = potionPrice;
    }

    @Override
    public String toString() {
        if (this.potionType.equals("Cura")) {
            return "Poção: " + this.potionName + " | Cura: " + this.potionHealHealth + " | Preço: " + this.potionPrice;
        }
        return "CONDICIONE A POÇÃO NO toString";
    }
    
    //Getters

    public int getPotionPrice() {
        return this.potionPrice;
    }

    public int getPotionHealHealth() {
        return this.potionHealHealth;
    }

    public String getPotionType() {
        return this.potionType; 
    }
}
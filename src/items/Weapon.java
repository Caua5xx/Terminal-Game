package items;

public class Weapon {

    private String name;
    private int price;
    private int attack;

    public Weapon(String weaponName, int weaponAttack, int weaponPrice) {
        this.name = weaponName;
        this.price = weaponPrice;
        this.attack = weaponAttack;
    }

    @Override
    public String toString() {
        return "Espada: " + this.name + " | Dano: " + this.attack + " | Preço: " + this.price;
    }

    //Getters

    public int getPrice() {
        return this.price;
    }

    public int getAttack() {
        return this.attack;
    }

    public String getName() {
        return this.name;
    }
}
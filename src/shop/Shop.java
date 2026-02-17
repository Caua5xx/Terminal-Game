package shop;
import entities.Player;
import items.Weapon;
import items.Potion;

public class Shop {

    public static void openShop(Player player) {
        Weapon sword1 = new Weapon("Espada de madeira", 2, 6);
        Weapon sword2 = new Weapon("Espada de Pedra", 5, 20);
        Weapon sword3 = new Weapon("Adaga Enferrujada", 8, 35);
        Potion healPotion = new Potion();

        System.out.println("\n===== Loja ====="+ "\n1 - " + sword1 + "\n2 - " + sword2 + "\n3 - " + sword3 + "\n4 - " + "Poção de cura [" + healPotion.getPotionHealHealth() + "] | Preço: " + healPotion.getPotionPrice() + "\n- Saldo: " + player.getGold());
    }

    public static void buyWeapon(Player player, Weapon weapon) {
        if (player.getGold() >= weapon.getPrice()) {
            player.setAttack(weapon.getAttack());
            player.decreaseGold(weapon.getPrice());
            System.out.println(weapon.getName() + " comprada com sucesso!");
        } else {
            System.out.println("Compra não permitida!");
        }
    }

    public static void buyPotion(Player player, Potion potion) {
        if (player.getGold() >= potion.getPotionPrice()) {
            player.increaseHealth(potion.getPotionHealHealth());
            player.decreaseGold(potion.getPotionPrice());
            System.out.println("Poção de cura comprada com sucesso!");
        } else {
            System.out.println("Compra não permitida!");
        }
    }
}
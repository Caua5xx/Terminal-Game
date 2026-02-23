package shop;
import entities.Player;
import items.Weapon;
import items.Potion;

public class Shop {

    static final Potion HEAL_POTION = new Potion("Poção de Cura", "Cura", 100, 15);
    static final Weapon SWORD_1 = new Weapon("Espada de Madeira", 2, 6);
    static final Weapon SWORD_2 = new Weapon("Espada de Pedra", 5, 20);
    static final Weapon SWORD_3 = new Weapon("Adaga Enferrujada", 8, 35);

    public static void openShop(Player player) {
        // *Melhora esse print
        System.out.print("""
        ========================================================
        |                         LOJA                         |
        --------------------------------------------------------
        | 1 - %-48s |
        | 2 - %-48s |
        | 3 - %-48s |
        | 4 - %-48s |
        ========================================================
        >> """.formatted(
            "🍷 " + HEAL_POTION,
            "🗡️  " + SWORD_1,
            "🗡️  " + SWORD_2,
            "🗡️  " + SWORD_3
        ));
    }

    public static void buyWeapon(Player player, Weapon weapon) {
        if (player.getGold() >= weapon.getPrice()) {
            player.setAttack(weapon.getAttack());
            player.decreaseGold(weapon.getPrice());
            System.out.println("💲 " + weapon.getName() + " comprada com sucesso!");
        } else {
            System.out.println("⚠️  Compra não permitida!");
        }
    }

    public static void buyPotion(Player player, Potion potion) {
        if (player.getGold() >= potion.getPotionPrice()) {
            player.increaseHealth(potion.getPotionHealHealth());
            player.decreaseGold(potion.getPotionPrice());
            System.out.println("💲 Poção de " + potion.getPotionType() + " comprada com sucesso!");
        } else {
            System.out.println("⚠️  Compra não permitida!");
        }
    }
}
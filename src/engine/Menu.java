package engine;
import entities.*;

public class Menu {

    public static void showMenuStatus(Player player, Enemy enemy, int currentLevel) {
        System.out.println("""
        
        ==================================
        |          PLAYER  STATUS        |
        ----------------------------------
        | ♥️  VIDA: %-21d |
        | ⚔️  ATAQUE: %-19d |
        | 💰 OURO: %-21d |
        | ⬆️  FASE: %-21d |
        ==================================
        |         INIMIGO  STATUS        |
        ----------------------------------
        | 🏷️  NOME: %-21s |
        | ♥️  VIDA: %-21d |
        | ⚔️  ATAQUE: %-19d |
        | 💰 DROP DE OURO: %-13d |
        ==================================\
        """.formatted(
            player.getHealth(),
            player.getAttack(),
            player.getGold(),
            currentLevel,
            enemy.getName(),
            enemy.getHealth(),
            enemy.getAttack(),
            enemy.getGoldRewards()
        ));
    }

    public static void clearScreen() {
        int i = 30;
        while (i > 0) {
            System.out.println();
            i--;
        }
    }

    public static void showActionMenu() {
        System.out.print("""
            
        ==================================
        |               MENU             |
        ----------------------------------
        | 1 - ⚔️  ATACAR                  |
        | 2 - 💰 LOJA                    |
        | 3 - 🚨 STATUS                  |
        | 4 - ❌ SAIR                    |
        ==================================
        >> """);
    }
}
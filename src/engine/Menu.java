package engine;
import entities.*;

public class Menu {

    public static void showMenu(Player player, Enemy enemy, int currentLevel) {
        System.out.println("""
        
        ==================================
        |          PLAYER  STATUS        |
        ----------------------------------
        | VIDA: %-24d |
        | ATAQUE: %-22d |
        | OURO: %-24d |
        | FASE: %-24d |
        ==================================
        |         INIMIGO  STATUS        |
        ----------------------------------
        | NOME: %-24s |
        | VIDA: %-24d |
        | ATAQUE: %-22d |
        | DROP DE OURO: %-16d |
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
}
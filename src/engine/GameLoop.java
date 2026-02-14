package engine;
import entities.*;
import java.util.Scanner;

public class GameLoop {
    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        //Player
        Player player = new Player();
        //Inimigos
        Goblin goblin = new Goblin();

        while (true) {
            System.out.println("\n1 - Atacar");
            int opcao = Integer.valueOf(scanner.nextLine());

            if (opcao == 1) {
                if (player.isAlive()) {
                    player.playerAttackEnemy(player, goblin);
                    System.out.println("Goblin " + goblin.getHealth());
                } else {
                    System.out.println("Você Morreu! Fim De Jogo!");
                    return;
                }

                if (goblin.isAlive()) {
                    goblin.enemyAttackPlayer(goblin, player);
                    System.out.println("Player  " + player.getHealth());
                } else {
                    goblin.newGoblin();
                    goblin.enemyAttackPlayer(goblin, player);
                    System.out.println("Player " + player.getHealth());
                }

            } else {
                return;
            }
        }
    }
}


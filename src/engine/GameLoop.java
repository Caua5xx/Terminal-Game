package engine;
import entities.*;
import items.*;
import shop.Shop;
import java.util.Scanner;

public class GameLoop {
    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        
        //Objetos

        //Player
        Player player = new Player();
        //Inimigo inicial
        Enemy enemy = new Enemy("Slime", 5, 1, 1);
        //Armas
        Weapon sword1 = new Weapon("Espada de madeira", 2, 6);
        Weapon sword2 = new Weapon("Espada de Pedra", 5, 20);
        //Poção
        Potion healPotion = new Potion();
        Weapon sword3 = new Weapon("Adaga Enferrujada", 8, 35);
        //Fase
        byte currentLevel = 1;

        while (true) {
            System.out.print("\n1 - ATACAR \n2 - LOJA \n3 - STATUS \n4 - SAIR \n>> ");
            int opcao = Integer.valueOf(scanner.nextLine());

            switch (opcao) {
                case 1:
                    if (player.isAlive()) {
                        player.playerAttackEnemy(player, enemy);
                        System.out.println("\nVida do Player: " + player.getHealth());
                    } else {
                        System.out.println("Você Morreu! Fim De Jogo!");
                        return;
                    }

                    if (enemy.isAlive()) {
                        enemy.enemyAttackPlayer(enemy, player);
                    } else {
                        player.increaseGold(enemy.getGoldRewards());
                        enemy = enemy.newEnemy(player, currentLevel);
                        enemy.enemyAttackPlayer(enemy, player);
                        System.out.println("Vida do Inimigo: " + enemy.getHealth());
                        System.out.println("Ouro: " + player.getGold());     //apenas Debug
                        currentLevel++;
                        System.out.println("Nível atual: " + currentLevel);
                    }
                    break;
                case 2:
                    Shop.openShop(player);
                    byte weaponNum = Byte.valueOf(scanner.nextLine());

                    switch (weaponNum) {
                        case 1:
                            Shop.buyWeapon(player, sword1);
                            break;
                        case 2:
                            Shop.buyWeapon(player, sword2);
                            break;
                        case 3:
                            Shop.buyWeapon(player, sword3);
                            break;
                        case 4:
                            Shop.buyPotion(player, healPotion);
                            break;
                        default:
                            System.out.println("Opção Inválida");
                    }
                    break;
                case 3:
                    Menu.showMenu(player, enemy, currentLevel);
                    break;
                case 4:
                    System.out.println("Deseja Sair? (sim/nao)");
                    String confirmExit = scanner.nextLine().strip().toLowerCase();
                    
                    if (confirmExit.equals("sim") || confirmExit.equals("s")) {
                        System.out.println("Saindo...");
                        return;
                    } else if (confirmExit.equals("nao") || confirmExit.equals("n")) {
                        System.out.println("Voltando...");
                        continue;
                    } else {
                        System.out.println("Resposta Inválida! \nVoltando...");
                    }
                default:
                    System.out.println("Opção Inválida");
            }
        }
    }
}
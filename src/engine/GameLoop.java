package engine;
import entities.*;
import items.*;
import shop.Shop;
import utils.clock.Stopwatch;
import java.util.Scanner;

public class GameLoop {
    public static void playGame() {        
        //Objetos

        //Player
        Player player = new Player();
        //Inimigo inicial
        Enemy enemy = new Enemy("Slime", 5, 1, 1);
        //Armas
        Weapon sword1 = new Weapon("Espada de Madeira", 2, 6);
        Weapon sword2 = new Weapon("Espada de Pedra", 5, 20);
        Weapon sword3 = new Weapon("Adaga Enferrujada", 8, 35);
        //Poção
        Potion healPotion = new Potion("Poção de Cura", "Cura", 100, 15);
        //Fase
        byte currentLevel = 1;
        //Scanner
        Scanner scanner = new Scanner(System.in);
        //Loading Time
        Stopwatch loadingTime = new Stopwatch();

        while (true) {
            Menu.showActionMenu();
            int opcao = Integer.valueOf(scanner.nextLine());

            switch (opcao) {
                case 1:
                    if (player.isAlive()) {
                        Menu.clearScreen();
                        player.playerAttackEnemy(player, enemy);
                        System.out.println("==================================");
                        System.out.println("| ♥️  Vida do Player: " + player.getHealth());
                    } else {
                        System.out.println("⚠️ Você Morreu! Fim De Jogo!");
                        return;
                    }

                    if (enemy.isAlive()) {
                        System.out.println("| ♥️  Vida do Inimigo: " + enemy.getHealth());
                        System.out.println("| 💰 Ouro: " + player.getGold());
                        System.out.println("==================================");
                        enemy.enemyAttackPlayer(enemy, player);

                    } else {
                        currentLevel++;
                        player.increaseGold(enemy.getGoldRewards());
                        enemy = enemy.newEnemy(player, currentLevel);
                        System.out.println("| ♥️  Vida do Inimigo: " + enemy.getHealth());
                        System.out.println("| 💰 Ouro: " + player.getGold());
                        System.out.println("| ⬆️  Nível atual: " + currentLevel);
                        System.out.println("==================================");
                    }
                    break;
                case 2:
                    Menu.clearScreen();
                    Shop.openShop(player);
                    byte itemNum = Byte.valueOf(scanner.nextLine());

                    switch (itemNum) {
                        case 1:
                            Shop.buyPotion(player, healPotion);
                            loadingTime.startStopwatch(1);
                            break;
                        case 2:
                            Shop.buyWeapon(player, sword1);
                            loadingTime.startStopwatch(1);
                            break;
                        case 3:
                            Shop.buyWeapon(player, sword2);
                            loadingTime.startStopwatch(1);
                            break;
                        case 4:
                            Shop.buyWeapon(player, sword3);
                            loadingTime.startStopwatch(1);
                            break;
                        default:
                            System.out.println(" ⚠️  Opção Inválida");
                            loadingTime.startStopwatch(1);
                    }
                    break;
                case 3:
                    Menu.clearScreen();
                    Menu.showMenuStatus(player, enemy, currentLevel);
                    loadingTime.startStopwatch(3);
                    break;
                case 4:
                    System.out.print("🚨 Deseja Sair? (sim/nao) \n>>");
                    String confirmExit = scanner.nextLine().strip().toLowerCase();
                    
                    if (confirmExit.equals("sim") || confirmExit.equals("s")) {
                        System.out.println("📢 Saindo...");
                        scanner.close();
                        loadingTime.startStopwatch(3);
                        return;
                    } else if (confirmExit.equals("nao") || confirmExit.equals("n")) {
                        System.out.println("📢 Voltando...");
                        loadingTime.startStopwatch(3);
                        continue;
                    } else {
                        System.out.println("⚠️  Resposta Inválida! \n📢 Voltando...");
                        loadingTime.startStopwatch(3);
                        break;
                    }
                default:
                    System.out.println("⚠️  Opção Inválida");
                    loadingTime.startStopwatch(1);
            }
        }
    }
}
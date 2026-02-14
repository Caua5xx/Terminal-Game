package app;
import engine.GameLoop;

public class Main {
    public static void main(String[] args) {        
        System.out.println("\nOlá Aventureiro! Seja Bem-vindo a mais uma aventura!");
        
        GameLoop game = new GameLoop();

        game.playGame();
    }
}
package app;
import engine.GameLoop;
import utils.clock.Stopwatch;

public class Main {
    public static void main(String[] args) {        
        
        Stopwatch loadingTime = new Stopwatch();

        System.out.println("\nOlá Aventureiro! Seja Bem-vindo a mais uma aventura!");
        loadingTime.startStopwatch(2);

        GameLoop.playGame();
    }
}
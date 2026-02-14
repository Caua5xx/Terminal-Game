package entities;

public class Goblin {
    
    private int health;
    private int attack;

    public Goblin() {
        this.health = 10;
        this.attack = 1;
    }

    //Getters

    public int getHealth() {
        return this.health;
    }

    public int getAttack() {
        return this.attack;
    }

    //Increasers

    public void increaseHealth(int value) {
        this.health += value;
    }

    //Decreasers

    public void decreaseHealth(int value) {
        this.health -= value;
    }

    //Other methods

    public void newGoblin() {
        this.health = 10;
    }

    public Boolean isAlive() {
        if (this.health > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void enemyAttackPlayer(Goblin enemy, Player player) {
        player.decreaseHealth(enemy.getAttack());
    }
}
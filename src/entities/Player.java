package entities;

public class Player {
    
    private int health;
    private int attack;

    public Player() {
        this.health = 100;
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

    public Boolean isAlive() {
        if (this.health > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void playerAttackEnemy(Player player, Goblin enemy) {
        enemy.decreaseHealth(player.getAttack());
    }
}
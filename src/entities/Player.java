package entities;

public class Player {
    
    private int health;
    private int attack;
    private int gold;

    public Player() {
        this.health = 100;
        this.attack = 1;
        this.gold = 0;
    }
    
    //Getters

    public int getHealth() {
        return this.health;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getGold() {
        return this.gold;
    }

    //Setters

    public void setAttack(int newAttack) {
        this.attack = newAttack;
    }

    //Increasers

    public void increaseHealth(int value) {
        this.health += value;
    }

    public void increaseGold(int value) {
        this.gold += value;
    }

    //Decreasers

    public void decreaseHealth(int value) {
        if (this.health < value) {
            this.health = 0;
        } else {
            this.health -= value;
        }
    }

    public void decreaseGold(int value) {
        this.gold -= value;
    }

    //Other methods

    public Boolean isAlive() {
        if (this.health > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void playerAttackEnemy(Player player, Enemy enemy) {
        enemy.decreaseHealth(player.getAttack());
    }
}
package entities;

public class Player {
    
    private int maxHealth;
    private int health;
    private int attack;
    private int gold;

    public Player() {
        this.maxHealth = 100;
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
        if (value + this.health > this.maxHealth) {
            this.health = maxHealth;
        } else {
            this.health += value;
        }
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
        if (this.gold < value) {
            this.gold = 0;
        } else {
            this.gold -= value;
        }
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
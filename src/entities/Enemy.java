package entities;

public class Enemy {
    
    private String name;
    private int health;
    private int attack;
    private int goldRewards;

    public Enemy(String enemyName, int enemyHealth, int enemyAttack, int enemyGoldRewards) {
        this.name = enemyName;
        this.health = enemyHealth;
        this.attack = enemyAttack;
        this.goldRewards = enemyGoldRewards;
    }

    //Getters

    public int getHealth() {
        return this.health;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getGoldRewards() {
        return this.goldRewards;
    }

    public String getName() {
        return this.name;
    }

    //Increasers

    public void increaseHealth(int value) {
        this.health += value;
    }

    //Decreasers

    public void decreaseHealth(int value) {
        if (this.health < value) {
            this.health = 0;
        } else {
            this.health -= value;
        }
    }

    //Other methods

    public Enemy newEnemy(Player player, int currentLevel) {
        if (currentLevel <= 10) {
            Enemy slime = new Enemy("Slime", 5, 1, 1);
            return slime;
        } else if (currentLevel > 10 && currentLevel <= 20) {
            Enemy goblin = new Enemy("Goblin", 7, 2, 3);
            return goblin;
        } else if (currentLevel > 20 && currentLevel <= 30) {
            Enemy lobo = new Enemy("Lobo", 10, 4, 5);
            return lobo;
        } else if (currentLevel > 30 && currentLevel <= 40) {
            Enemy ogro = new Enemy("Ogro", 15, 6, 7);
            return ogro;
        } else {
            Enemy dragao = new Enemy("Dragão", 20, 8, 10);
            return dragao;
        }
    }

    public Boolean isAlive() {
        if (this.health > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void enemyAttackPlayer(Enemy enemy, Player player) {
        player.decreaseHealth(enemy.getAttack());
        System.out.println("Inimigo:  " + enemy.getHealth());
    }
}
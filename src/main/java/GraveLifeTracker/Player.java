package GraveLifeTracker;

public class Player {
    private String name;
    private int life;
    private int creatures;
    private int totalCards;

    // Constructor with default values
    public Player(String name) {
        this.name = name;
        this.life = 40;  // Default life for Commander
        this.creatures = 0;
        this.totalCards = 0;
    }

    // Name getter and setter
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Life methods
    public void setLife(int life) {
        this.life = life;
    }

    public int getLife() {
        return life;
    }

    // Method to change game mode (Standard/Commander)
    public void setGameMode(String mode) {
        if (mode.equalsIgnoreCase("Standard")) {
            this.life = 20;
        } else if (mode.equalsIgnoreCase("Commander")) {
            this.life = 40;
        }
    }

    // Creature count methods
    public void setCreatures(int creatures) {
        this.creatures = creatures;
    }

    public int getCreatures() {
        return creatures;
    }

    public void incrementCreatures() {
        if (this.creatures < 100) {
            this.creatures++;
        }
    }

    public void decrementCreatures() {
        if (this.creatures > 0) {
            this.creatures--;
        }
    }

    // Total cards methods
    public void setTotalCards(int totalCards) {
        this.totalCards = totalCards;
    }

    public int getTotalCards() {
        return totalCards;
    }

    public void incrementTotalCards() {
        if (this.totalCards < 100) {
            this.totalCards++;
        }
    }

    public void decrementTotalCards() {
        if (this.totalCards > 0) {
            this.totalCards--;
        }
    }

    // Reset methods
    public void resetCreatures() {
        this.creatures = 0;
    }

    public void resetTotalCards() {
        this.totalCards = 0;
    }

    public void resetLife(String mode) {
        setGameMode(mode);  // This will set life to either 20 or 40
    }

    public void resetAll(String mode) {
        resetCreatures();
        resetTotalCards();
        resetLife(mode);
    }
}
import java.util.Scanner;

public class Character {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter details for Warrior
        System.out.println("Enter details for Warrior:");
        System.out.print("Name: ");
        String warriorName = scanner.nextLine();
        System.out.print("Health: ");
        int warriorHealth = scanner.nextInt();
        System.out.print("Attack Power: ");
        int warriorAttackPower = scanner.nextInt();
        System.out.print("Special Skill - Defense: ");
        int warriorDefense = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Warrior warrior = new Warrior(warriorName, warriorHealth, warriorAttackPower, warriorDefense);

        // Prompt user to enter details for Mage
        System.out.println("\nEnter details for Mage:");
        System.out.print("Name: ");
        String mageName = scanner.nextLine();
        System.out.print("Health: ");
        int mageHealth = scanner.nextInt();
        System.out.print("Attack Power: ");
        int mageAttackPower = scanner.nextInt();
        System.out.print("Special Skill - Mana: ");
        int mageMana = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Mage mage = new Mage(mageName, mageHealth, mageAttackPower, mageMana);

        // Prompt user to enter details for Archer
        System.out.println("\nEnter details for Archer:");
        System.out.print("Name: ");
        String archerName = scanner.nextLine();
        System.out.print("Health: ");
        int archerHealth = scanner.nextInt();
        System.out.print("Attack Power: ");
        int archerAttackPower = scanner.nextInt();
        System.out.print("Special Skill - Arrows: ");
        int archerArrows = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Archer archer = new Archer(archerName, archerHealth, archerAttackPower, archerArrows);

        // Simulate a battle
        System.out.println("\n---- BATTLE STARTS ----");

        // Archer attacks Warrior
        archer.attack(warrior);

        // Mage attacks Archer
        mage.attack(archer);

        // Warrior attacks Mage
        warrior.attack(mage);

        // Archer attacks Warrior again
        archer.attack(warrior);

        // Mage attempts another magical attack
        mage.attack(archer);

        // Archer runs out of arrows and tries to attack again
        archer.attack(warrior);

        // Warrior delivers the final blow
        warrior.attack(mage);

        // Close the scanner
        scanner.close();
    }

    protected String name;
    protected int health;
    protected int attackPower;

    public Character(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    // Method to attack another character.
    public void attack(Character opponent) {
        System.out.println(this.name + " attacks " + opponent.name);
        opponent.receiveDamage(this.attackPower);
    }

    // Method to receive damage.
    public void receiveDamage(int damage) {
        this.health -= damage;
        System.out.println(this.name + " receives " + damage + " damage. Health left: " + this.health);

        // if health drops below 0, the character dies.
        if(this.health<=0) {
            System.out.println(this.name + " has been defeated!");
        }
    }

    // Method to check if the character is still alive.
    public boolean isAlive() {
        return this.health > 0;
    }
}


// Warrior Subclass
class Warrior extends Character {
    private int defense; // Additional defense for the warrior

    public Warrior(String name, int health, int attackPower, int defense){
        super(name, health, attackPower);
        this.defense = defense;
    }

    // The warrior can take less damage due to his defense
    @Override
    public void receiveDamage(int damage) {
        int reduceDamage = Math.max(damage - this.defense, 0); // Defense reduces damages
        System.out.println(this.name + " block some of the damage!");
        super.receiveDamage(reduceDamage); // Call to the method of the parent class
    }
}

// Mage Subclass
class Mage extends Character {
    private int mana; // Magic Energy

    public Mage(String name, int health, int attackPower, int mana) {
        super(name, health, attackPower);
        this.mana = mana;
    }

    // The mage has a special attack based on mana
    @Override
    public void attack(Character opponent) {
        if (mana > 0) {
            System.out.println(this.name + " cast a powerful spell on " + opponent.name);
            opponent.receiveDamage(this.attackPower + 10); // Additional magic damage
            mana -= 10; // The mage consumes mana when attacking
        } else {
            System.out.println(this.name + " has no mana left and performs a weak attack.");
            super.attack(opponent);
        }
    }
}

// Archer Subclass
class Archer extends Character {
    private int arrows;

    public Archer(String name, int health, int attackPower, int arrows) {
        super(name, health, attackPower);
        this.arrows = arrows;
    }

    // The archer has to check if he has arrows to attack
    @Override
    public void attack(Character opponent) {
        if (arrows > 0) {
            System.out.println(this.name + " shoots an arrow at " + opponent.name);
            opponent.receiveDamage(this.attackPower);
            arrows--; // Decrease the number of arrows
            System.out.println(this.name + " has " + arrows + " arrows left.");
        } else {
            System.out.println(this.name + " has no arrows left and cannot attack!");
        }
    }
}
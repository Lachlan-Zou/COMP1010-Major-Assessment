// Character.java - Class a character in the RPG game
public class Character {
    String playerName;
    int healthpoint;
    int strength;
    int defence;
    DiceRandomiser dice; // Dice randomizer to add unpreditability

    public Character( int healthpoint, int strength, int defence, String playerName){
        this.playerName = playerName;
        this.healthpoint=healthpoint;
        this.strength = strength;
        this.defence = defence;
        this.dice = new DiceRandomiser(); //Initialize dice roller

    }
    // Method to attack 
    public void attack(Character enemy) {
        int diceRoll = dice.rollDice();  // Get a random dice roll
        int baseDamage = this.strength - enemy.defence;  // Base damage calculation (Strength - Defence)
        int damage = baseDamage + diceRoll;  // Final damage after adding dice roll

        // Ensure that a minimum of 1 damage is dealt, even if the calculation is negative or zero
        if (damage <= 0) {
            damage = 1;  // Set minimum damage to 1
        }
        else{
            enemy.healthpoint -= damage;  // Reduce enemy health points by the damage dealt
            System.out.println(this.playerName + " attacked " + enemy.playerName + " causing " + damage + " damage.");
        }
    }

    // Method to defend
    public void defend(Character enemy){
        //negate any damage based on characters strength and enemy defence
        int damage = enemy.strength - this.defence;
        if(damage > 0){
            this.healthpoint -= damage;
            System.out.println(enemy.playerName + " attacked " + this.playerName + " causing " + damage + " damage.");    

        }
        else{
            System.out.println(this.playerName + " blocked the attack!");
        }
}
}

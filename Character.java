import java.util.List;
// Character.java - Class a character in the RPG game
public class Character {
    String playerName;
    int healthpoint;
    int strength;
    int defence;
    int speed;
    DiceRandomiser dice; // Dice randomizer to add unpreditability
    //List<Character> team;

    public Character( int healthpoint, int strength, int defence, int speed, String playerName){
        this.playerName = playerName;
        this.healthpoint=healthpoint;
        this.strength = strength;
        this.defence = defence;
        this.speed = speed;
        this.dice = new DiceRandomiser(); //Initialize dice roller


    }
    // Method to attack 
    public void attack(Character enemy, List<Character> enemyTeam) {
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
            if (enemy.healthpoint<=0) {
                enemyTeam.remove(enemy);
                System.out.println(enemy.playerName + " Has been killed!");
            }
        }
    }

    // Method to defend
    public void defend(Character enemy){
        //negate any damage based on characters strength and enemy defence
        int damage = enemy.strength - this.defence;
        if(damage > 0){
            this.healthpoint -= damage;
            System.out.println(enemy.playerName + " attacked " + this.playerName + " causing " + damage + " damage.");    
            if (this.healthpoint<=0) {
                System.out.println(this.playerName+ " has been killed!");
            }
        }
        else{
            System.out.println(this.playerName + " blocked the attack!");
        }
    }

    public void dodge(Character enemy, List<Character> enemyTeam) {
        int diceRoll = dice.rollDice();  // Get a random dice roll
        int baseDamage = this.strength - enemy.defence;  // Base damage calculation (Strength - Defence)
        int damage = baseDamage + diceRoll;  // Final damage after adding dice roll

        if (damage <= 0) {
            damage = 1;  // Set minimum damage to 1
        }
        
        boolean dodgeHit = false;
        if (enemy.speed>this.speed) {
            this.healthpoint -=damage;
            System.out.println(this.playerName+" was too slow! "  + damage + " was dealt.");
            if (this.healthpoint<=0) {
                System.out.println(this.playerName+ " has been killed!");
            }
        }
        for (int i = 0; i <5-this.speed; i++) {
            int rand = (int) (Math.random()*5);
            if (rand==this.speed) {
                dodgeHit = true;
                break;
            }
        }
        if (dodgeHit) {
            System.out.println(this.playerName+"'s dodge was only half successful.");
            this.healthpoint -= damage/2;
            System.out.println(this.playerName+ " took " + damage/2);
            if (this.healthpoint<=0) {
                System.out.println(this.playerName+ " has been killed!");
            }
        }
        else {
            System.out.println(this.playerName+ " successfully dodges!");
            enemy.healthpoint -= damage*1.5;
            System.out.println(this.playerName+ " counterattacks! dealing " + damage*1.5 + " damage!");
            if (enemy.healthpoint<=0) {
                enemyTeam.remove(enemy);
                System.out.println(enemy.playerName + " Has been killed!");
            }
        }

    }
}

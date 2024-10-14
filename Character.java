public class Character {
    int healthpoint;
    int strength;
    int defence;

    public Character( int healthpoint, int strength, int defence){
        this.healthpoint=healthpoint;
        this.strength = strength;
        this.defence = defence;

    }

    public void attack(Character enemy){
        //damage based on characters strength and enemy defence
        int damage = this.strength - enemy.defence;
        if(damage > 0){
            enemy.healthpoint -= damage;
            System.out.println(this + " attacked " + enemy + " causing " + damage + " damage.");

        }
        else{
            System.out.println(enemy + " blocked the attack!");
        }
    }
    
}

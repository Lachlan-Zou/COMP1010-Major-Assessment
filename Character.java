public class Character {
    int healthpoint;
    int strength;
    int defence;

    public Character( int healthpoint, int strength, int defence){
        this.healthpoint=healthpoint;
        this.strength = strength;
        this.defence = defence;

    }
// method to attack 
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

    public void defend(Character enemy){
        //negate any damage based on characters strength and enemy defence
        int damage = enemy.strength - this.defence;
        if(damage > 0){
            this.healthpoint -= damage;
            System.out.println(enemy + " attacked " + this + " causing " + damage + " damage.");    

        }
        else{
            System.out.println(this + " blocked the attack!");
        }
}
}

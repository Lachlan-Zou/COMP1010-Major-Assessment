// DiceRandomiser.java - Class to simulate rolling a six sided die to add randomness to the game
import java.util.ArrayList;
import java.util.Random;

public class DiceRandomiser {
    public ArrayList<Integer> dicesides;

// Constructor for 6 sided dice
    public DiceRandomiser () {
        dicesides = new ArrayList<>();
        for(int i = 1; i<=6; i++){
            dicesides.add(i); // Add dice sides (Betwen 1 and 6)
        }
    }

// Rolling dice with random side
    public int rollDice(){
        Random random = new Random();
        int randomSide = random.nextInt(dicesides.size()); // Randomly pick dice side
        return dicesides.get(randomSide); // Return the random dice value.
    }
}

//     public static void main(String[] args) {
//         DiceRandomiser dice = new DiceRandomiser();

//     // Rolling dice and printing result
//         int result = dice.rollDice();
//         System.out.println("The dice landed on: " + result);
//     }
// }

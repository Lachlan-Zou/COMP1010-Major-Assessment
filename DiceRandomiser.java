import java.util.ArrayList;
import java.util.Random;

public class DiceRandomiser {
    public ArrayList<Integer> dicesides;

// Constructor for 6 sided dice
    public DiceRandomiser () {
        dicesides = new ArrayList<>();
        for(int i = 1; i<=6; i++){
            dicesides.add(i);
        }
    }

// Rolling dice with random side
    public int rollDice(){
        Random random = new Random();
        int randoms = random.nextInt(dicesides.size());
        return dicesides.get(randoms);
    }
}

//     public static void main(String[] args) {
//         DiceRandomiser dice = new DiceRandomiser();

//     // Rolling dice and printing result
//         int result = dice.rollDice();
//         System.out.println("The dice landed on: " + result);
//     }
// }

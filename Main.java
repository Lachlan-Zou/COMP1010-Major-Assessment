import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create Team 1
        List<Character> team1 = new ArrayList<>();
        System.out.println("Create Team 1:");
        team1.add(RPGGame.createCharacter(input, "Player 1"));
        team1.add(RPGGame.createCharacter(input, "Player 2"));

        // Create Team 2
        List<Character> team2 = new ArrayList<>();
        System.out.println("Create Team 2:");
        team2.add(RPGGame.createCharacter(input, "Player 3"));
        team2.add(RPGGame.createCharacter(input, "Player 4"));

        // Start the battle
        RPGGame.battle(team1, team2);

        input.close();
    }
}


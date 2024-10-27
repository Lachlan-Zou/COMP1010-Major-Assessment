// Main.java - Entry point of the game
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static String filePath = "info.txt"; // The relative path for the tutorial directory.
    static boolean inPlay = true; // Creates flag for the program to initate the game.
    public static void main(String[] args) {
        try { // Writes tutorial information into the txt file
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)); 
            writer.write("The game is a turn-based combat game with different classes and actions.");
            writer.write("\nPlayers are put onto teams of two.");
            writer.write("\nPlayers can choose whether to attack, defend");
            writer.write("\nThe game ends once one team has defeated the other.");
            writer.write("\nPlayers can also choose what class they want to play as.");
            writer.write("\nPress Enter to read about class stats");
            writer.write("\nHuman has base stats, health: 16, strength: 16 and defence: 18.");
            writer.write("\nOrc has base stats, health: 20, strength: 18 and defence: 14.");
            writer.write("\nElf has base stats, health: 15, strength: 14 and defence: 20.");
            writer.write("\nDwarf has base stats, health: 18, strength: 20 and defence: 16.");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    
        System.out.println("Welcome to the Game");
        System.out.println("Press Enter to continue");
        System.out.print("> ");

        Scanner input = new Scanner(System.in);
        String enterkey = input.nextLine(); // Reads input for an enter key.

        if (enterkey.isEmpty()) {
            while (inPlay) { // Loops switch case statement to prevent the player from being stuck on the options menu.
                String prompt = "Select, (1) play or (2) tutorial.";
                System.out.println(prompt);
                int select = input.nextInt();
                switch (select) { 
                    case 1: 
                        System.out.println("You've selected to play!"); 
                        gamePlay(); // Player selects playing the game.
                        break;
                    case 2:
                        System.out.println("You've selected the tutorial.");
                        Info.Reader(filePath); // Player selects the tutorial of the game.
                        break;
                    default:
                        System.out.println("Invalid choice, automatically selecting tutorial.");
                        Info.Reader(filePath); // If the player doesn't choose a valid option, go through the tutorial.
                        break;
            }
            }
        }

        input.close(); // Close scanner input
    }

    public static void gamePlay() {
        Scanner input = new Scanner(System.in);
        //border title 
        System.out.println();
        System.out.println("===============================");
        System.out.println("    Player Selection Phase!     ");
        System.out.println("===============================");


            // Create Team 1
            List<Character> team1 = new ArrayList<>();
            System.out.println();
            System.out.println("Create Team 1:");
            team1.add(RPGGame.createCharacter(input, "Player 1"));
            team1.add(RPGGame.createCharacter(input, "Player 2"));
    
            // Create Team 2
            List<Character> team2 = new ArrayList<>();
            System.out.println();
            System.out.println("-------------------------------");
            System.out.println();
            System.out.println("Create Team 2:");
            team2.add(RPGGame.createCharacter(input, "Player 3"));
            team2.add(RPGGame.createCharacter(input, "Player 4"));
    
            
    
            // Start the battle
            RPGGame.battle(team1, team2);
            // Once the game is over, end the in play condition.
            inPlay = false; 
    }
}


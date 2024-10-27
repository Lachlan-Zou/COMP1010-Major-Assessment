// RPGGame.java - Main Logic for handling the battle mechanics
import java.util.List;
import java.util.Scanner;

public class RPGGame {

    // Method for Character selection process
    public static Character createCharacter(Scanner input, String playerName) {
        //more readible and clear
        System.out.println();
        System.out.println(playerName + ", choose your race:");
        System.out.println("  (1) Human    (2) Orc");
        System.out.println("  (3) Elf      (2) Dwarf");
        System.out.print("> ");
        Integer choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println(playerName + " selected Human.");
                return new Character(16, 16, 18, playerName); // Human stats
            case 2:
                System.out.println(playerName + " selected Orc.");
                return new Character(20, 18, 14, playerName); // Orc stats
            case 3:
                System.out.println(playerName + " selected Elf.");
                return new Character(15, 14, 20, playerName); // Elf stats
            case 4:
                System.out.println(playerName + " selected Dwarf.");
                return new Character(18, 20, 16, playerName); // Dwarf stats
            default:
                System.out.println("Invalid choice, defaulting to Human.");
                return new Character(16, 16, 18, playerName); // Default choice Human
        }
    }

    public static void battle(List<Character> team1, List<Character> team2) {
        int round = 1;
        int winningTeam = 0; // Initialize winningTeam to 0 (no winner yet)
    
        while (isTeamAlive(team1) && isTeamAlive(team2)) {
            System.out.println("\n===============================");
            System.out.printf("           Round %d            \n", round);
            System.out.println("===============================\n");
    
            // Team 1's turn
            for (Character character : team1) {
                if (character.healthpoint > 0) { // Only active characters
                    takeTurn(character, team2);
                    if (!isTeamAlive(team2)) {
                        winningTeam = 1; // Set winning team to 1 (Team 1 wins)
                        break; // Exit the loop if Team 2 is defeated
                    }
                }
            }
    
            // Check if Team 2 is defeated
            if (winningTeam == 1) {
                break; // Exit while loop if Team 1 has won
            }
    
            // Team 2's turn
            for (Character character : team2) {
                if (character.healthpoint > 0) { // Only active characters
                    takeTurn(character, team1);
                    if (!isTeamAlive(team1)) {
                        winningTeam = 2; // Set winning team to 2 (Team 2 wins)
                        break; // Exit the loop if Team 1 is defeated
                    }
                }
            }
    
            // Check if Team 1 is defeated
            if (winningTeam == 2) {
                break; // Exit while loop if Team 2 has won
            }
    
            round++; // Move to the next round
        }
    
        // Print the victory message after the battle concludes
        printVictoryMessage(winningTeam);
    }
    //Displays the winner 
    public static void printVictoryMessage(int winningTeam) {
        if (winningTeam == 0) {
            System.out.println("The battle ended in a draw!");
        } else {
            System.out.println("===============================");
            System.out.println("         Battle Result         ");
            System.out.println("===============================");
            System.out.println();
            System.out.println("         Team " + winningTeam + " Wins! ");
            System.out.println();
            System.out.println("Congratulations on your victory!");
            System.out.println("===============================");
        }
    }

    // Method to simulate a single character's turn
    public static void takeTurn(Character character, List<Character> enemyTeam) {
        Scanner input = new Scanner(System.in);
        Character enemy = enemyTeam.get((int) (Math.random() * enemyTeam.size())); // Random enemy target

        System.out.printf("\n--- %s's Turn ---\n", character.playerName);
        System.out.printf("Current HP: %d\n", character.healthpoint);
        System.out.println("Choose action: (1) Attack  (2) Defend");
        System.out.print("> ");
        int action = input.nextInt();

        // Performs the chosen action by the Player
        switch (action) {
            case 1:
                character.attack(enemy); // Attack the selected enemy
                break;
            case 2:
                character.defend(enemy); // Defend from the enemy
                break;
            default:
                System.out.println("Invalid action, attacking by default.");
                character.attack(enemy); // Default to attack if invalid action
                break;
        }
    }
    // Method to check if any characters on a team are still alive
    public static boolean isTeamAlive(List<Character> team) {
        for (Character character : team) {
            if (character.healthpoint > 0) { // If any character has health left, the team is still alive
                return true;
            }
        }
        return false; // Returns false once all characters are defeated
    }


}


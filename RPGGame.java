// RPGGame.java - Main Logic for handling the battle mechanics
import java.util.List;
import java.util.Scanner;

public class RPGGame {

    // Method for Character selection process
    public static Character createCharacter(Scanner input, String playerName) {
        System.out.println(playerName + ", choose your race: (1) Human (2) Orc (3) Elf (4) Dwarf (5) Info");
        int choice = input.nextInt();
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
            case 5:
                System.out.println("Selected Info");
                //info();
            default:
                System.out.println("Invalid choice, defaulting to Human.");
                return new Character(16, 16, 18, playerName); // Default choice Human
        }
    }

    public static void battle(List<Character> team1, List<Character> team2) {
        int round = 1;
        while (isTeamAlive(team1) && isTeamAlive(team2)) {
            System.out.println("\n--- Round " + round + " ---");

            // Team 1's turn
            for (Character character : team1) {
                if (character.healthpoint > 0) {
                    takeTurn(character, team2);
                    if (!isTeamAlive(team2)) break; // End the game if Team 2 is defeated
                }
            }

            // Is team 2 alive?
            if (!isTeamAlive(team2)) {
                System.out.println("Team 1 wins the battle!");
                return;
            }

            // Team 2's turn
            for (Character character : team2) {
                if (character.healthpoint > 0) {
                    takeTurn(character, team1);
                    if (!isTeamAlive(team1)) break; // End the game if Team 1 is defeated
                }
            }
            
            // Is team 1 alive?
            if (!isTeamAlive(team1)) {
                System.out.println("Team 2 wins the battle!");
                return;
            }

            round++; //Next Round
        }
    }

    // Method to simulate a single character's turn
    public static void takeTurn(Character character, List<Character> enemyTeam) {
        Scanner input = new Scanner(System.in);
        Character enemy = enemyTeam.get((int) (Math.random() * enemyTeam.size())); // Random enemy target
        System.out.println(character.playerName + " is taking a turn. Choose action: (1) Attack (2) Defend");
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


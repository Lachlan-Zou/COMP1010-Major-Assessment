import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("Choose your race: (1) Human (2) Orc (3) Elf (4) Dwarf");
        Scanner cha = new Scanner(System.in);
        int choice = cha.nextInt();



        switch (choice) {
            case 1:
                System.out.println("You selected Human.");
                // Modify the program logic for Human
                Character Human = new Character(16,16,18);
                System.out.println("Human: Hp " + Human.healthpoint + " | Str " +Human.strength + " | Def " + Human.defence);
                // Modify the stats
                break;
            case 2:
                System.out.println("You selected Orc.");
                // Modify the program logic for Orc
                Character Orc = new Character(18, 20, 12);
                System.out.println("Orc: Hp " + Orc.healthpoint + " | Str " +Orc.strength + " | Def " + Orc.defence);
                 // Modify the stats
                break;
            case 3:
                System.out.println("You selected Elf.");
                // Modify the program logic for Elf
                Character Elf = new Character(14, 14, 22);
                System.out.println("Elf: Hp " + Elf.healthpoint + " | Str " +Elf.strength + " | Def " + Elf.defence);
                 // Modify the stats
                break;
            case 4:
                System.out.println("You selected Dwarf.");
                // Modify the program logic for Dwarf
                Character Dwarf = new Character(15, 18, 17);
                System.out.println("Dwarf: Hp " + Dwarf.healthpoint + " | Str " +Dwarf.strength + " | Def " + Dwarf.defence);
                 // Modify the stats
                break;
            default:
                System.out.println("Invalid choice.");
                break;

    }
cha.close();
}
}

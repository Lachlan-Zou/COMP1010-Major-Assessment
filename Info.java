import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class Info {
    public static void Reader(String filePath){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            Scanner scanner = new Scanner(System.in);

            readRecursive(reader, scanner); // Begins recursive function.

            reader.close(); // Closes the reader.

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void readRecursive(BufferedReader reader, Scanner scanner) throws IOException {
        String line = reader.readLine(); 

        if (line == null) { // When the last line has been reached, return to Main.
            System.out.println(""); 
            return;
        }

        System.out.println(line);
        System.out.println("Press Enter");
        scanner.nextLine(); // Takes the next line of info.txt
        readRecursive(reader, scanner); // Enters the line recursively
    }
}
package himanshukhadka.passwordgenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.util.Date;

/* Password class */
public class password {

    private String passString;
    private String timeStamp; // For time stamp of generated password

    // Generate method to generate password
    public String generate(int length, boolean hasSpecialCharacters) {
        // Random object to create random integers
        SecureRandom random = new SecureRandom();
        // Char array to create pass string
        char[] passString = new char[length];

        // Define character sets
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:',.<>?/~`";

        String characterSet = lowerCase + upperCase + digits;

        if (hasSpecialCharacters) {
            characterSet += specialChars;
        }

        for (int i = 0; i < length; i++) {
            passString[i] = characterSet.charAt(random.nextInt(characterSet.length()));
        }

        Date date = new Date();
        this.timeStamp = date.toString();
        // Sets pass String
        this.passString = new String(passString);
        save(this.passString);
        // Returns string of password
        return new String(passString);
    }

    // Saves password to file along with time stamp
    public void save(String passString) {
        File file = new File("data.txt");
        String filepath = "data.txt";

        try {
            // Creating file
            if (file.createNewFile()) {
                System.out.println("File is created Successfully!");
            } else {
                System.out.println("File already exists!");
            }
        } catch (IOException ex) {
            System.out.println("Oh no you got an IO exception");
            ex.printStackTrace();
        }

        try (FileWriter filewriter = new FileWriter(filepath, true)) {
            PrintWriter writer = new PrintWriter(filewriter);
            // Adding data
            writer.print(this.passString);
            writer.print("   '''" + getTimeStamp() + "'''");
            writer.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get time data
    public String getTimeStamp() {
        return timeStamp;
    }
}

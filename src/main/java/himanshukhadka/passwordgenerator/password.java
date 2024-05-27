package himanshukhadka.passwordgenerator;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;



/* Password class*/
public class password{

    private String passString;
    private String timeStamp; //For time stamp of generated password

    //Generate method to generate password
    public String generate(int length, boolean hasSpecialCharacters){
        //Random object to create random integers
        SecureRandom random = new SecureRandom();
        //Char array to create pass string
        char[] passString = new char[length];
        //Loop through length
        for (int i = 0; i < length; i++ ){

            if (hasSpecialCharacters){
                passString[i] = (char) random.nextInt(32,122);
            }else{
                int temp = 0;
                do {
                    temp = random.nextInt(48, 122);
                } while(!(temp > 90 && temp < 95));
                passString[i] = (char)temp;
            }


        }
        Date date = new Date();
        this.timeStamp = date.toString();
        //Sets pass String
        this.passString = new String(passString);
        save(this.passString);
        //returns string
        return new String(passString);
//        return passwords;
    }

    public void save(String passString){
        File file = new File("data.txt");
        String filepath = "data.txt";

        try{
            //Creating file
            if (file.createNewFile()){
                System.out.println("File is created Successfully!");
            }else{
                System.out.println("File already exists!");
            }

            //Appending Data



        }catch (IOException ex){
            System.out.println("Oh no you got an IO exception");
            ex.printStackTrace();
        }

        try(FileWriter filewriter = new FileWriter(filepath,true)){
            PrintWriter writer = new PrintWriter(filewriter);
            //Adding data
            writer.print(this.passString);
            writer.print("   '''"+getTimeStamp()+"'''");
            writer.println();
        }catch (IOException e){

        }


    }

    //Get time data
    public String getTimeStamp(){
        return timeStamp;
    }
}


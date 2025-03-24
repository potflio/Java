import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("source.txt");
            FileWriter writer = new FileWriter("destination.txt");

            int character;
            while ((character = reader.read()) != -1) { // Reading character by character
                writer.write(character); // Writing character by character
            }

            reader.close();
            writer.close();
            System.out.println("File copied successfully without buffering.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

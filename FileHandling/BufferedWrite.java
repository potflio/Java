import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWrite {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("buffered_example.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("Hello, this is a buffered write example.");
            bufferedWriter.newLine(); // Writing a new line
            bufferedWriter.write("Buffered writing improves performance.");

            bufferedWriter.close(); // Close the writer
            System.out.println("Successfully written to the file using BufferedWriter.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

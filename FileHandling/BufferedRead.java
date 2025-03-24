import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedRead {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("buffered_example.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close(); // Close the reader
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

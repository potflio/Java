import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("buffered_example.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("copied_file.txt"));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            reader.close();
            writer.close();
            System.out.println("File copied successfully using buffering.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

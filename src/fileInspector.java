import javax.swing.*;
import java.io.*;


public class fileInspector {
    public static void main(String[] args)
    {
        JFileChooser fileChooser = new JFileChooser("src");
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    lineCount++;
                    wordCount += line.split("\\s+").length;
                    charCount += line.length();
                }

                System.out.println("\n--- Summary report ---");
                System.out.println("file name: " + file.getName());
                System.out.println("number of lines: " + lineCount);
                System.out.println("number of words: " + wordCount);
                System.out.println("number of charactrers: " + charCount);
            } catch (IOException e) {
                System.out.println("an error occurred while reading the file");
                e.printStackTrace();
            }
        } else {
            System.out.println("no file selected");
        }
    }
}
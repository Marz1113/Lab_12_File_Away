import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();

        System.out.println("Enter the user data (leave blank to finish):");
        while (true) {
            System.out.print("first name: ");
            String firstName = scanner.nextLine();
            if (firstName.isEmpty()) break;

            System.out.print("Last name: ");
            String lastName = scanner.nextLine();
            System.out.print("id number (6 digits): ");
            String idNumber = scanner.nextLine().replaceAll("\\D", "").replaceAll("^\\d{0,5}$", "000000").substring(0,6);
            System.out.print("email: ");
            String email = scanner.nextLine();
            System.out.print("birth year: ");
            String birthYear = scanner.nextLine();

            String record = firstName + ", " + lastName + ", " + idNumber + ", " + email + ", " + birthYear;
            records.add(record);

            System.out.println("record successfully added");
        }

        System.out.println("enter the file name to save (eg. data.csv): ");
        String fileName = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/" + fileName))) {
            for (String record : records) {
                writer.write(record);
                writer.newLine();
            }

            System.out.println("data saved to: " + fileName);
        } catch (IOException e) {
            System.out.println("an error occurred while saving the file");
            e.printStackTrace();
        }
    }
}

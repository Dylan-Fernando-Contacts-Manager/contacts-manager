import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Contacts {

    public static void main(String[] args) {


        System.out.println("1. View contacts");
        System.out.println("2. Add new contact");
        System.out.println("3. Search by contact name");
        System.out.println("4. Delete contact");
        System.out.println("5. exit");
        System.out.println("Enter an option between 1 and 5");

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        if (name.equals("1")) {
            System.out.println("Name: | Phone Number:");
            System.out.println("---------------------");
            printContacts();
        } else if (name.equals("2")) {
            System.out.println("Please add your contact with name first then the number\n" + "ex: jim | number");
            addContact();
            System.out.println("Add completed");
        } else if (name.equals("3")) {
            System.out.println("Search for a contact: ");
            searchName();
        } else if (name.equals("4")) {
            System.out.println("Type the name of the person you wish to delete from your life becky... -_-");
            deleteContact();
            System.out.println("Contact deleted");
        } else if (name.equals("5")) {
            System.out.println("Low battery gtg...iphone life");
        }
    }

    public static List<String> contacts() {
        List<String> b = new ArrayList<>();

        Path names = Paths.get("src", "contacts.txt");
        try {
            b = Files.readAllLines(names);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }

    public static void printContacts() {

        List<String> b = new ArrayList<>();

        Path names = Paths.get("src", "contacts.txt");
        try {
            b = Files.readAllLines(names);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < b.size(); i++) {
            System.out.println(b.get(i));
        }
    }

    public static void addContact() {

        Scanner sc = new Scanner(System.in);
        String ct = sc.nextLine();
        try {
            Files.write(Paths.get("src", "contacts.txt"),
                    Arrays.asList(ct),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void searchName() {
        Scanner sc = new Scanner(System.in);
        String srch = sc.nextLine();

        List<String> allContacts = contacts();
        for (int i = 0; i < allContacts.size(); i++) {
            if (contacts().get(i).contains(srch)) {
                System.out.println(contacts().get(i));
            }
        }
    }

    public static void deleteContact() {

        Scanner sc = new Scanner(System.in);
        String ct = sc.nextLine();

        List<String> allContacts = contacts();
        for (int i = 0; i < allContacts.size(); i++) {
            if (allContacts.get(i).contains(ct)) {
                allContacts.remove(i);
            }
        }
        try {
            Files.write(Paths.get("src", "contacts.txt"),
                    (allContacts));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



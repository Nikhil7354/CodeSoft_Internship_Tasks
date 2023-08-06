import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task5 {
    private List<Contact> contacts;
    private Scanner scanner;

    public Task5() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("----- Address Book System -----");
            System.out.println("1. Add a new contact");
            System.out.println("2. Edit contact information");
            System.out.println("3. Search for a contact");
            System.out.println("4. Display all contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    editContact();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    displayContacts();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }

    private void addContact() {
        System.out.println("----- Add a New Contact -----");
        System.out.print("Enter the contact's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the contact's phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter the contact's email address: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber, email);
        contacts.add(contact);

        System.out.println("Contact added successfully.");
    }

    private void editContact() {
        System.out.println("----- Edit Contact Information -----");
        System.out.print("Enter the contact's name: ");
        String name = scanner.nextLine();

        Contact contact = findContactByName(name);
        if (contact != null) {
            System.out.print("Enter the new phone number: ");
            String newPhoneNumber = scanner.nextLine();
            contact.setPhoneNumber(newPhoneNumber);

            System.out.print("Enter the new email address: ");
            String newEmail = scanner.nextLine();
            contact.setEmail(newEmail);

            System.out.println("Contact information updated successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    private void searchContact() {
        System.out.println("----- Search for a Contact -----");
        System.out.print("Enter the contact's name: ");
        String name = scanner.nextLine();

        Contact contact = findContactByName(name);
        if (contact != null) {
            System.out.println("Contact found:");
            System.out.println(contact);
        } else {
            System.out.println("Contact not found.");
        }
    }

    private void displayContacts() {
        System.out.println("----- All Contacts -----");
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    private Contact findContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Task5 addressBook = new Task5();
        addressBook.run();
    }
}

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}


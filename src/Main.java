import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ContactManager manager = new ContactManager();

    public static void main(String[] args) {
        System.out.println("==================================");
        System.out.println("       CONTACT LIST MANAGER       ");
        System.out.println("==================================");

        boolean running = true;
        while (running) {
            showMenu();
            int choice = readChoice();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    manager.displayArrayList();
                    break;
                case 3:
                    manager.displayLinkedList();
                    break;
                case 4:
                    searchContact();
                    break;
                case 5:
                    running = false;
                    System.out.println("\\nThank you for using Contact List Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1 to 5.");
            }
        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\\n--------------- MENU ---------------");
        System.out.println("1. Add Contact");
        System.out.println("2. Display Contacts (ArrayList)");
        System.out.println("3. Display Contacts (LinkedList)");
        System.out.println("4. Search Contact (Name / Phone)");
        System.out.println("5. Exit");
        System.out.println("------------------------------------");
        System.out.print("Enter your choice: ");
    }

    private static int readChoice() {
        String input = scanner.nextLine().trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void addContact() {
        System.out.println("\\n--- ADD NEW CONTACT ---");
        String name = readRequired("Enter name: ");
        String phone = readRequired("Enter phone number: ");
        String email = readRequired("Enter email: ");

        if (!phone.matches("[0-9]{7,15}")) {
            System.out.println("Invalid phone number. Use 7 to 15 digits only.");
            return;
        }
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            System.out.println("Invalid email address. Contact was not added.");
            return;
        }

        Contact contact = new Contact(name, phone, email);
        if (manager.addContact(contact)) {
            System.out.println("Contact added successfully!");
        } else {
            System.out.println("A contact with this phone number already exists.");
        }
    }

    private static void searchContact() {
        System.out.println("\\n--- SEARCH CONTACT ---");
        System.out.println("1. Search by name");
        System.out.println("2. Search by phone number");
        System.out.print("Choose search type: ");
        int type = readChoice();

        Contact result = null;
        if (type == 1) {
            System.out.print("Enter name: ");
            result = manager.searchByName(scanner.nextLine());
        } else if (type == 2) {
            System.out.print("Enter phone number: ");
            result = manager.searchByPhone(scanner.nextLine());
        } else {
            System.out.println("Invalid search option.");
            return;
        }

        if (result == null) {
            System.out.println("No matching contact found.");
        } else {
            System.out.println("\\nContact found:");
            System.out.println("Name  : " + result.getName());
            System.out.println("Phone : " + result.getPhoneNumber());
            System.out.println("Email : " + result.getEmail());
        }
    }

    private static String readRequired(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) return value;
            System.out.println("This field cannot be empty. Please try again.");
        }
    }
}

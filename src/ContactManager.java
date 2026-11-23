import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ContactManager {
    // The same contacts are stored in both structures to demonstrate each one.
    private final ArrayList<Contact> arrayContacts = new ArrayList<>();
    private final LinkedList<Contact> linkedContacts = new LinkedList<>();

    public boolean addContact(Contact contact) {
        if (contact == null) {
            return false;
        }

        // Avoid adding the same phone number more than once.
        if (searchByPhone(contact.getPhoneNumber()) != null) {
            return false;
        }

        arrayContacts.add(contact);
        linkedContacts.add(contact);
        return true;
    }

    public void displayArrayList() {
        displayList(arrayContacts, "CONTACTS (ArrayList)");
    }

    public void displayLinkedList() {
        displayList(linkedContacts, "CONTACTS (LinkedList)");
    }

    private void displayList(List<Contact> contacts, String heading) {
        System.out.println("\\n" + heading);
        System.out.println("---------------------------------------------------------------");
        if (contacts.isEmpty()) {
            System.out.println("No contacts saved yet.");
        } else {
            System.out.printf("%-4s %-20s | %-15s | %s%n",
                    "No.", "Name", "Phone", "Email");
            System.out.println("---------------------------------------------------------------");
            for (int i = 0; i < contacts.size(); i++) {
                System.out.printf("%-4d %s%n", i + 1, contacts.get(i));
            }
        }
        System.out.println("---------------------------------------------------------------");
    }

    public Contact searchByName(String name) {
        if (name == null) return null;
        for (Contact contact : arrayContacts) {
            if (contact.getName().equalsIgnoreCase(name.trim())) {
                return contact;
            }
        }
        return null;
    }

    public Contact searchByPhone(String phoneNumber) {
        if (phoneNumber == null) return null;
        for (Contact contact : arrayContacts) {
            if (contact.getPhoneNumber().equals(phoneNumber.trim())) {
                return contact;
            }
        }
        return null;
    }

    public int getContactCount() {
        return arrayContacts.size();
    }
}

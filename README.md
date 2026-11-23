# Contact List Manager (Java)

A working console-based Java prototype based on the uploaded project report.

## Features
- Add a contact with name, phone number, and email.
- Display contacts stored in an `ArrayList`.
- Display the same contacts stored in a `LinkedList`.
- Search by contact name (case-insensitive) or exact phone number.
- Basic input validation and duplicate-phone prevention.

## Project structure
```text
ContactListManager/
├── src/
│   ├── Contact.java
│   ├── ContactManager.java
│   └── Main.java
└── README.md
```

## Requirements
- Java JDK 8 or later
- Terminal / Command Prompt, VS Code, Eclipse, or IntelliJ IDEA

## Run using terminal
Open a terminal inside the `ContactListManager` folder and run:

```bash
javac -d out src/*.java
java -cp out Main
```

On Windows PowerShell, the same commands work if the JDK `bin` folder is on PATH.

## Menu
1. Add Contact
2. Display Contacts (ArrayList)
3. Display Contacts (LinkedList)
4. Search Contact (Name / Phone)
5. Exit

## Data-structure note
`ContactManager` stores each new contact in both an `ArrayList<Contact>` and a
`LinkedList<Contact>`. This makes it possible to demonstrate and compare both
structures in the prototype. Searching is performed by traversing the stored
ArrayList.

## Current prototype limitation
Contacts are held in memory, so they are cleared when the program exits.
Persistent file/database storage, editing, deletion, sorting, and a GUI can be
added as future enhancements, consistent with the project report.

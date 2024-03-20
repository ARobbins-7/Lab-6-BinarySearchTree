// Andrew Robbins
// CS 145
// 3/10/24
// Lab 6
import java.util.*;

// This program will create a Binary Search Tree that stores information on people, it 
// has the ability to add, delete, modify and search for different information. 
// I did not get this to sort alphabetically or anything like that.
public class Dictionary {

    // Main method of the program holds the starting menu and called the required method.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // I left the menu in main as its pretty small, and not clogging it up.
        System.out.println();
        System.out.println("Dictionary Menu:");
        System.out.println("1. Add/Change a Record");
        System.out.println("2. Delete Record");
        System.out.println("3. Show Records List (only prints names and keys)");
        System.out.println("4. Show Specific Record");
        System.out.println("5. Exit");
        System.out.println();

        function(scanner);

    }

    // function creates all of the functionality of this program, adding/modifying the 
    // records, deleting them showing records and exiting the program.
    public static void function(Scanner scanner) {
        BinarySearchTree bst = new BinarySearchTree();
        // I decided to try using a switch statement instead of a bunch of 
        // if else statements, in my opinion it looks cleaner.
        int choice;
        do {
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter an Integer");
                System.out.println();
                scanner.nextLine(); 
                choice = -1; 
            } else {
                choice = scanner.nextInt();
                scanner.nextLine(); 
                switch (choice) {
                    // Add or change
                    case 1:
                        System.out.print("Enter primary key (integers only): ");
                        int key = scanner.nextInt();
                        scanner.nextLine(); 
                    
                        Node existingNode = bst.searchNode(key);
                        if (existingNode != null) {
                            System.out.println();
                            System.out.println("Record with primary key " + key +
                             " already exists.");
                            System.out.println("Currently this record is: ");
                            bst.showOne(key);
                            System.out.println();
                            System.out.print("Do you want to update the"
                            + "existing record? (Y/N): ");

                            String answer = scanner.nextLine().trim().toUpperCase();
                            if (answer.equals("Y")) {
                                System.out.println();
                                System.out.print("Enter first name: ");
                                String firstName = scanner.nextLine();
                                System.out.print("Enter last name: ");
                                String lastName = scanner.nextLine();
                                System.out.print("Enter street address: ");
                                String streetAddress = scanner.nextLine();
                                System.out.print("Enter city: ");
                                String city = scanner.nextLine();
                                System.out.print("Enter state: ");
                                String state = scanner.nextLine();
                                System.out.print("Enter zip code: ");
                                String zip = scanner.nextLine();
                                System.out.print("Enter email: ");
                                String email = scanner.nextLine();
                                System.out.print("Enter phone number: ");
                                String phoneNumber = scanner.nextLine();
                    
                                existingNode.firstName = firstName;
                                existingNode.lastName = lastName;
                                existingNode.streetAddress = streetAddress;
                                existingNode.city = city;
                                existingNode.state = state;
                                existingNode.zip = zip;
                                existingNode.email = email;
                                existingNode.phoneNumber = phoneNumber;
                    
                                System.out.println("Record updated successfully.");
                            } else {
                                System.out.println("Record not updated.");
                            }
                        } else {
                            System.out.print("Enter first name: ");
                            String firstName = scanner.nextLine();
                            System.out.print("Enter last name: ");
                            String lastName = scanner.nextLine();
                            System.out.print("Enter street address: ");
                            String streetAddress = scanner.nextLine();
                            System.out.print("Enter city: ");
                            String city = scanner.nextLine();
                            System.out.print("Enter state: ");
                            String state = scanner.nextLine();
                            System.out.print("Enter zip code: ");
                            String zip = scanner.nextLine();
                            System.out.print("Enter email: ");
                            String email = scanner.nextLine();
                            System.out.print("Enter phone number: ");
                            String phoneNumber = scanner.nextLine();
                    
                            bst.addNode(key, firstName, lastName, streetAddress,
                             city, state, zip, email, phoneNumber);
                            System.out.println("Record added successfully.");
                        }
                        System.out.println();
                        break;
                    // Delete
                    case 2:
                        System.out.print("Enter primary key of record to delete: ");
                        int deleteKey = scanner.nextInt();
                        scanner.nextLine(); 
                        bst.deleteNode(deleteKey);
                        System.out.println("Record deleted successfully.");
                        break;
                    // Show All
                    case 3:
                        bst.showAll(bst.getRoot());
                        break;
                    // Shows one record
                    case 4:
                        int num;
                        while (true) {
                            System.out.print("Enter the primary key of" 
                            + "the record to show: ");
                            if (scanner.hasNextInt()) {
                                num = scanner.nextInt();
                                scanner.nextLine(); 
                                break; 
                            } else {
                                System.out.println("Please enter an integer.");
                                System.out.println();
                                scanner.nextLine(); 
                            }
                        }
                        bst.showOne(num);
                        break;
                    // Exits the program
                    case 5:
                        System.out.println("Exiting program.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        System.out.println();
                }
            }
        } while (choice != 5);

        scanner.close();
    }
}
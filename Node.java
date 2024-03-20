import java.util.Scanner;

// This class represents a node in a binary search tree.
class Node {
    String firstName;
    String lastName;
    String streetAddress;
    String city;
    String state;
    String zip;
    String email;
    String phoneNumber;
    int primaryKey;
    Node left;
    Node right;

    // Initalizes a node with given information.
    public Node(int key, String firstName, String lastName, String streetAddress, 
    String city, String state, String zip, String email, String phoneNumber) {
        this.primaryKey = key;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.left = null;
        this.right = null;
    }
}

// Andrew Robbins
// CS 145
// 3/10/24
// Lab 6
import java.util.*;

// This class represents a binary search tree, and has functionality for storing and 
// printing nodes, etc.
class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    // gets the root node
    public Node getRoot() {
        return root;
    }

    // public facing method that adds a node to the tree, this was the only way
    // I could think to do this. Im sure there are better ways that dont have two
    // methods.
    public void addNode(int key, String firstName, String lastName, String streetAddress,
    String city, String state, String zip, String email, String phoneNumber) {

        root = addRecursive(root, key, firstName, lastName, 
        streetAddress, city, state, zip, email, phoneNumber);
    }

    // Method that adds a node to the tree
    private Node addRecursive(Node current, int key, String firstName, 
    String lastName, String streetAddress, String city, String state, 
    String zip, String email, String phoneNumber) {

        if (current == null) {
            return new Node(key, firstName, lastName, 
            streetAddress, city, state, zip, email, phoneNumber);
        }

        if (key < current.primaryKey) {
            current.left = addRecursive(current.left, key, firstName, lastName, 
            streetAddress, city, state, zip, email, phoneNumber);
        } else if (key > current.primaryKey) {
            current.right = addRecursive(current.right, key, firstName, 
            lastName, streetAddress, city, state, zip, email, phoneNumber);
        } else {
            System.out.println("Duplicate key. Record not added.");
        }

        return current;
    }

    // Method to display all nodes with only key and name
    public void showAll(Node node) {
        if (node != null) {
            showAll(node.left);
            System.out.println("Key: " + node.primaryKey + ", Name: " + 
            node.firstName + " " + node.lastName);
            System.out.println();
            showAll(node.right);
        }
    }

    // Shows one node or Record in detail based off user input 
    public void showOne(int key) {
        Node found = searchNode(key);
        if (found != null) {
            System.out.println("Key: " + found.primaryKey + ", Name: " + 
            found.firstName + " " + found.lastName + ", Address: " + 
            found.streetAddress + ", City: " + found.city + ", State: " + 
            found.state + ", Zip Code: " + found.zip + ", Email: " + found.email
            + ", Phone Number: " + found.phoneNumber);
            System.out.println();
        } else {
            System.out.println("Record not found.");
        }
    }

     // public method to search for a node in the tree based on its key
    public Node searchNode(int key) {
        return searchRecursive(root, key);
    }

    // Method to search for a node
    private Node searchRecursive(Node current, int key) {
        if (current == null || current.primaryKey == key) {
            return current;
        }

        if (key < current.primaryKey) {
            return searchRecursive(current.left, key);
        }

        return searchRecursive(current.right, key);
    }

    // Public method to delete a node
    public void deleteNode(int key) {
        root = deleteRecursive(root, key);
    }

    // Method to delete a node
    private Node deleteRecursive(Node current, int key) {
        if (current == null) {
            return null;
        }

        if (key == current.primaryKey) {
            if (current.left == null && current.right == null) {
                return null;
            } else if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            } else {
                Node successor = findSuccessor(current.right);
                current.primaryKey = successor.primaryKey;
                current.right = deleteRecursive(current.right, successor.primaryKey);
                return current;
            }
        } else if (key < current.primaryKey) {
            current.left = deleteRecursive(current.left, key);
            return current;
        } else {
            current.right = deleteRecursive(current.right, key);
            return current;
        }
    }

    // Finds the successor in a tree
    private Node findSuccessor(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}

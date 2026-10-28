
import java.util.Scanner;

public class BinarySearchTree {

    static class Node {
        int rollNo;
        Node left, right;

        Node(int rollNo) {
            this.rollNo = rollNo;
            left = right = null;
        }
    }

    static Node root = null;

    // Insert a student roll number
    static Node insert(Node root, int rollNo) {
        if (root == null) {
            return new Node(rollNo);
        }

        if (rollNo < root.rollNo) {
            root.left = insert(root.left, rollNo);
        } else if (rollNo > root.rollNo) {
            root.right = insert(root.right, rollNo);
        } else {
            System.out.println("Roll number already exists.");
        }

        return root;
    }

    // Search for a student roll number
    static boolean search(Node root, int rollNo) {
        if (root == null) {
            return false;
        }

        if (root.rollNo == rollNo) {
            return true;
        }

        if (rollNo < root.rollNo) {
            return search(root.left, rollNo);
        }

        return search(root.right, rollNo);
    }

    // Find the smallest value in a subtree
    static Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Delete a student roll number
    static Node delete(Node root, int rollNo) {
        if (root == null) {
            return null;
        }

        if (rollNo < root.rollNo) {
            root.left = delete(root.left, rollNo);
        } else if (rollNo > root.rollNo) {
            root.right = delete(root.right, rollNo);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            Node successor = findMin(root.right);
            root.rollNo = successor.rollNo;
            root.right = delete(root.right, successor.rollNo);
        }

        return root;
    }

    // Inorder traversal: Left, Root, Right
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.rollNo + " ");
            inorder(root.right);
        }
    }

    // Preorder traversal: Root, Left, Right
    static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.rollNo + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Postorder traversal: Left, Right, Root
    static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.rollNo + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, rollNo;

        do {
            System.out.println("\n--- Student BST Menu ---");
            System.out.println("1. Insert Student Roll Number");
            System.out.println("2. Search Student Roll Number");
            System.out.println("3. Delete Student Roll Number");
            System.out.println("4. Inorder Traversal");
            System.out.println("5. Preorder Traversal");
            System.out.println("6. Postorder Traversal");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter roll number: ");
                    rollNo = sc.nextInt();
                    root = insert(root, rollNo);
                    System.out.println("Insertion operation completed.");
                    break;

                case 2:
                    System.out.print("Enter roll number to search: ");
                    rollNo = sc.nextInt();
                    if (search(root, rollNo)) {
                        System.out.println("Student roll number found.");
                    } else {
                        System.out.println("Student roll number not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter roll number to delete: ");
                    rollNo = sc.nextInt();
                    if (search(root, rollNo)) {
                        root = delete(root, rollNo);
                        System.out.println("Student roll number deleted.");
                    } else {
                        System.out.println("Student roll number not found.");
                    }
                    break;

                case 4:
                    System.out.print("Inorder: ");
                    inorder(root);
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Preorder: ");
                    preorder(root);
                    System.out.println();
                    break;

                case 6:
                    System.out.print("Postorder: ");
                    postorder(root);
                    System.out.println();
                    break;

                case 7:
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);

        sc.close();
    }
}

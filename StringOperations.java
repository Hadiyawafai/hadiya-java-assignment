import java.util.Scanner;
 
public class StringOperations {

    // Method to reverse a string
    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }

    // Method to convert string to uppercase
    public static String convertToUpper(String str) {
        return str.toUpperCase();
    }

    // Method to convert string to lowercase
    public static String convertToLower(String str) {
        return str.toLowerCase();
    }

    // Method to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        String reversed = reverseString(str);
        return str.equalsIgnoreCase(reversed);
    }

    // Method to count vowels and consonants in a string
    public static void countVowelsAndConsonants(String str) {
        int vowels = 0, consonants = 0;
        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if ("aeiou".indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    // Method to display the menu and handle user choice
    public static void displayMenu() {
        System.out.println("\nString Manipulation Toolkit");
        System.out.println("1. Reverse String");
        System.out.println("2. Convert to Uppercase");
        System.out.println("3. Convert to Lowercase");
        System.out.println("4. Check Palindrome");
        System.out.println("5. Count Vowels and Consonants");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        int choice;

        do {
            // Display the menu
            displayMenu();
            while (!scanner.hasNextInt()) {
                scanner.next(); // consume the invalid input
                System.out.print("Invalid choice! Please enter a number between 1 and 6: ");
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline after integer input

            switch (choice) {
                case 1: // Reverse String
                    System.out.print("Enter a string to reverse: ");
                    input = scanner.nextLine();
                    System.out.println("Reversed String: " + reverseString(input));
                    break;

                case 2: // Convert to Uppercase
                    System.out.print("Enter a string to convert to uppercase: ");
                    input = scanner.nextLine();
                    System.out.println("Uppercase String: " + convertToUpper(input));
                    break;

                case 3: // Convert to Lowercase
                    System.out.print("Enter a string to convert to lowercase: ");
                    input = scanner.nextLine();
                    System.out.println("Lowercase String: " + convertToLower(input));
                    break;

                case 4: // Check Palindrome
                    System.out.print("Enter a string to check for palindrome: ");
                    input = scanner.nextLine();
                    if (isPalindrome(input)) {
                        System.out.println("The string is a palindrome.");
                    } else {
                        System.out.println("The string is not a palindrome.");
                    }
                    break;

                case 5: // Count Vowels and Consonants
                    System.out.print("Enter a string to count vowels and consonants: ");
                    input = scanner.nextLine();
                    countVowelsAndConsonants(input);
                    break;

                case 6: // Exit
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        } while (choice != 6); // Repeat the menu until the user chooses to exit

        scanner.close();
    }
}

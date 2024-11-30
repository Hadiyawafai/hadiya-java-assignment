import java.util.Scanner;

public class TemperatureConverter {

    // Method to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    // Method to convert Celsius to Kelvin
    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    // Method to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    // Method to convert Fahrenheit to Kelvin
    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit - 32) * 5/9 + 273.15;
    }

    // Method to convert Kelvin to Celsius
    public static double kelvinToCelsius(double kelvin) {
        if (kelvin < 0) {
            System.out.println("Invalid Kelvin value. Kelvin cannot be negative.");
            return Double.NaN;
        }
        return kelvin - 273.15;
    }

    // Method to convert Kelvin to Fahrenheit
    public static double kelvinToFahrenheit(double kelvin) {
        if (kelvin < 0) {
            System.out.println("Invalid Kelvin value. Kelvin cannot be negative.");
            return Double.NaN;
        }
        return (kelvin - 273.15) * 9/5 + 32;
    }

    // Method to display the menu and handle user choice
    public static void displayMenu() {
        System.out.println("\nTemperature Converter");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Celsius to Kelvin");
        System.out.println("3. Fahrenheit to Celsius");
        System.out.println("4. Fahrenheit to Kelvin");
        System.out.println("5. Kelvin to Celsius");
        System.out.println("6. Kelvin to Fahrenheit");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double temperature, result;
        int choice;

        do {
            // Display the menu
            displayMenu();

            // Handle invalid menu input
            while (!scanner.hasNextInt()) {
                scanner.next(); // Consume the invalid input
                System.out.print("Invalid choice! Please enter a number between 1 and 7: ");
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline after integer input

            switch (choice) {
                case 1: // Celsius to Fahrenheit
                    System.out.print("Enter temperature in Celsius: ");
                    temperature = scanner.nextDouble();
                    result = celsiusToFahrenheit(temperature);
                    System.out.println("Temperature in Fahrenheit: " + result);
                    break;

                case 2: // Celsius to Kelvin
                    System.out.print("Enter temperature in Celsius: ");
                    temperature = scanner.nextDouble();
                    result = celsiusToKelvin(temperature);
                    System.out.println("Temperature in Kelvin: " + result);
                    break;

                case 3: // Fahrenheit to Celsius
                    System.out.print("Enter temperature in Fahrenheit: ");
                    temperature = scanner.nextDouble();
                    result = fahrenheitToCelsius(temperature);
                    System.out.println("Temperature in Celsius: " + result);
                    break;

                case 4: // Fahrenheit to Kelvin
                    System.out.print("Enter temperature in Fahrenheit: ");
                    temperature = scanner.nextDouble();
                    result = fahrenheitToKelvin(temperature);
                    System.out.println("Temperature in Kelvin: " + result);
                    break;

                case 5: // Kelvin to Celsius
                    System.out.print("Enter temperature in Kelvin: ");
                    temperature = scanner.nextDouble();
                    result = kelvinToCelsius(temperature);
                    if (!Double.isNaN(result)) {
                        System.out.println("Temperature in Celsius: " + result);
                    }
                    break;

                case 6: // Kelvin to Fahrenheit
                    System.out.print("Enter temperature in Kelvin: ");
                    temperature = scanner.nextDouble();
                    result = kelvinToFahrenheit(temperature);
                    if (!Double.isNaN(result)) {
                        System.out.println("Temperature in Fahrenheit: " + result);
                    }
                    break;

                case 7: // Exit
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        } while (choice != 7); // Repeat the menu until the user chooses to exit

        scanner.close();
    }
}

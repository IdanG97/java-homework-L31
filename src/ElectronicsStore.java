import java.util.Scanner;

public class ElectronicsStore {

    public static void main(String[] args) {
        String[] items = {"computer", "screen", "mouse", "printer", "keyboard"};

        // Available items
        System.out.println("Available items: computer, screen, mouse, printer, keyboard");
        System.out.println("Please select items you want to purchase (comma-separated):");

        // User input
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] selectedItems = userInput.split(",");

        // Total amount
        double totalAmount = calculateTotal(selectedItems);
        System.out.println("Total amount to be paid: $" + totalAmount);

        // Payment method
        System.out.println("Choose a payment method (cash, check, credit):");
        String paymentMethod = scanner.nextLine();

        boolean isCreditValid = true;
        if (paymentMethod.equals("credit")) {
            System.out.println("Is the credit card valid? (true/false):");
            isCreditValid = scanner.nextBoolean();
        }
        processPayment(totalAmount, paymentMethod, isCreditValid);

        scanner.close();
    }

    // Calculate the total amount
    public static double calculateTotal(String[] items) {
        double total = 0;
        for (String item : items) {
            switch (item.trim().toLowerCase()) {
                case "computer":
                    total += 2500;
                    break;
                case "screen":
                    total += 1200;
                    break;
                case "mouse":
                    total += 250;
                    break;
                case "printer":
                    total += 500;
                    break;
                case "keyboard":
                    total += 350;
                    break;
                default:
                    System.out.println("Item not recognized: " + item);
            }
        }
        return total;
    }

    // Process the payment
    public static void processPayment(double totalAmount, String paymentMethod, boolean isCreditValid) {
        switch (paymentMethod.toLowerCase()) {
            case "cash":
                System.out.println("Please give the amount $" + totalAmount + " in cash to the cashier.");
                break;
            case "check":
                System.out.println("Please write a check for the amount $" + totalAmount + ".");
                break;
            case "credit":
                if (isCreditValid) {
                    System.out.println("The amount $" + totalAmount + " has been debited from your credit card.");
                } else {
                    System.out.println("The credit card is not valid, try another payment option.");
                }
                break;
            default:
                System.out.println("Invalid payment method. Please choose cash, check, or credit.");
        }
    }
}

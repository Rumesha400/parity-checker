import java.util.Scanner;

public class paritychecker {

    public static String checkParity(int data) {
        int onesCount = 0;

        while (data != 0) {
            onesCount += (data & 1); 
            data >>= 1; 
        }

    
        if (onesCount % 2 == 0) {
            return "Even Parity"; 
        } else {
            return "Odd Parity"; 
        }
    }

  
    public static boolean isValidInteger(String input) {
        try {
            int num = Integer.parseInt(input); 
            if (num < 0) {
                return false; 
            }
            return true; 
        } catch (NumberFormatException e) {
            return false; 
        }
    }

    // ANSI escape codes for color
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";

    public static void main(String[] args) {
  
        Scanner scanner = new Scanner(System.in);

     
        System.out.println(GREEN + "==================== Parity Checker ====================" + RESET);
        System.out.println(BLUE + "Welcome to the Parity Checker Program!" + RESET);
        System.out.println(GREEN + "======================================================" + RESET);

        while (true) {
            // Ask the user to input an integer
            System.out.print(
                    YELLOW + "\nEnter a non-negative integer to check its parity (or type 'exit' to quit): " + RESET);
            String input = scanner.nextLine();

            // If the user types 'exit', terminate the loop
            if (input.equalsIgnoreCase("exit")) {
                System.out.println(GREEN + "\nThank you for using the Parity Checker. Goodbye!" + RESET);
                break;
            }

            // Validate the input
            if (!isValidInteger(input)) {
                System.out.println(RED + "Error! Please enter a valid non-negative integer." + RESET);
                continue; 
            }

   
            int data = Integer.parseInt(input);

        
            String binary = Integer.toBinaryString(data);
            System.out.println("\n" + BLUE + "Binary representation of " + data + " is: " + RESET + binary);
            System.out.println(GREEN + "The parity of " + data + " is: " + RESET + checkParity(data));
        }

        scanner.close();
    }
}

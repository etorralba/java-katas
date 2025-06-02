import java.util.Scanner;
import java.util.Set;

public class BasicCalculator {

    public static void main(String[] args) {

        // Initialization
        Scanner reader = new Scanner(System.in);
        boolean isFirst = true;
        double result = 0.0;

        System.out.println("Welcome to the basic calculator!");
        while (true){
            // Get user input and validate inputs
            Set<String> validOperands = Set.of("+", "-", "*", "/");

            double doubleA = 0;
            // First operation
            if (isFirst){
                doubleA = readDouble(reader, "Select the first number (a)");

                isFirst = false;
            } else {
                doubleA = result;
                System.out.println("a now is: " + result);

            }

            // Get operand
            String operand = null;
            while (operand == null){
                String temp = readInput(reader, "Which operation would you like to perform?");
                if (!validOperands.contains(temp)) {
                    System.out.println("Input should be one of this: +, -, *, /, end");
                } else {
                    operand = temp;
                }
            }
            if (operand.equals("end")){
                break;
            }

            // Get second number
            double doubleB = readDouble(reader, "Select the second number (b)");

            // Perform calculation
            result = performCalculation(operand, doubleA, doubleB);

            // Print results
            Result calculationResult = new Result(result);
            System.out.println(calculationResult);
        }

        Result finalResult = new Result(result);
        System.out.println(finalResult);
        reader.close();
    }

    public record Result(double result){
        @Override
        public String toString(){
            return "Result: " + result ;
        }
    }

    public static String readInput(Scanner scanner, String prompt ) {
        System.out.println(prompt);

        String input = scanner.nextLine().trim();
        if (input.equalsIgnoreCase("end")){
            System.out.println("Goodbye!");
            System.exit(0);
        }
        return input;
    }

    public static double readDouble(Scanner scanner, String prompt){
        while (true){
            String input = readInput(scanner, prompt);
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number or type 'end' to exit.");
            }
        }
    }

    public static double performCalculation(String operator, double double1, double double2){
        return switch (operator) {
            case "+" -> addition(double1, double2);
            case "-" -> subtraction(double1, double2);
            case "*" -> multiplication(double1, double2);
            case "/" -> division(double1, double2);
            default -> throw new IllegalArgumentException("Invalid operator");
        };
    }

    private static double addition(double a, double b){
        return a + b;
    }

    private static double subtraction(double a, double b){
        return a - b;
    }

    private static double multiplication(double a, double b){
            return a * b;
        }

    private static double division(double a, double b){
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

}

import java.util.Stack;

public class CommandLineCalculator {

    // Method to check if a character is an operator
    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // Method to get the precedence of operators
    public static int getPrecedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return -1;
    }

    // Method to perform the arithmetic operation
    public static double applyOperation(double a, double b, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': 
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return a / b;
            default: throw new UnsupportedOperationException("Invalid operator");
        }
    }

    // Method to evaluate the expression
    public static double evaluate(String expression) {
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // Ignore spaces
            if (c == ' ') continue;

            // If the character is a number, push it to the values stack
            if (Character.isDigit(c)) {
                StringBuilder number = new StringBuilder();
                // Handle multi-digit numbers
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    number.append(expression.charAt(i));
                    i++;
                }
                values.push(Double.parseDouble(number.toString()));
                i--; // Adjust index to not skip the next character
            }

            // If the character is an opening parenthesis, push it to the operators stack
            else if (c == '(') {
                operators.push(c);
            }

            // If the character is a closing parenthesis, solve the entire expression inside parentheses
            else if (c == ')') {
                while (operators.peek() != '(') {
                    values.push(applyOperation(values.pop(), values.pop(), operators.pop()));
                }
                operators.pop(); // Pop the '(' from the stack
            }

            // If the character is an operator
            else if (isOperator(c)) {
                while (!operators.isEmpty() && getPrecedence(operators.peek()) >= getPrecedence(c)) {
                    values.push(applyOperation(values.pop(), values.pop(), operators.pop()));
                }
                operators.push(c);
            }
        }

        // Apply remaining operations
        while (!operators.isEmpty()) {
            values.push(applyOperation(values.pop(), values.pop(), operators.pop()));
        }

        return values.pop(); // The result is the last remaining value
    }

    public static void main(String[] args) {
        // Test expressions
        String[] expressions = {
            "5 + 3 * 2",         // Basic precedence
            "(5 + 3) * 2",       // Parentheses affecting precedence
            "10 + 2 * 6 / (3 + 1)" // Combination of all operations and parentheses
        };

        // Evaluate and display results
        for (String expr : expressions) {
            try {
                System.out.println("Expression: " + expr);
                double result = evaluate(expr);
                System.out.println("Result: " + result + "\n");
            } catch (Exception e) {
                System.out.println("Error evaluating expression '" + expr + "': " + e.getMessage());
            }
        }
    }
}

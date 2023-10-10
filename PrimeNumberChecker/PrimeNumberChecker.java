import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimeNumberChecker extends JFrame {
    private JTextField numberInput;
    private JButton checkButton;
    private JLabel resultLabel;

    public PrimeNumberChecker() {
        // Set up the frame
        setTitle("Prime Number Checker"); // Set the title of the JFrame
        setSize(400, 150); // Set the size of the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Specify the close operation
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create components
        numberInput = new JTextField(10); // Initialize the text field with a width of 10 characters
        checkButton = new JButton("Check"); // Initialize the button with the label "Check"
        resultLabel = new JLabel(); // Initialize the label for displaying the result

        // Set up layout
        setLayout(new FlowLayout()); // Set the layout manager for the JFrame to FlowLayout
        add(new JLabel("Enter a number: ")); // Add a label to prompt the user for input
        add(numberInput);
        add(checkButton);
        add(resultLabel);

        // Add action listener to the check button
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkPrime(); // Call the checkPrime() method when the button is clicked
            }
        });
    }

    private void checkPrime() { // Define a private method to check if a number is prime
        String inputText = numberInput.getText(); // Get the user's input as a text string
        try {
            int number = Integer.parseInt(inputText); // Parse the input string to an integer
            if (isPrime(number)) { // Check if the parsed number is prime
                resultLabel.setText(number + " is a prime number.");
            } else {
                resultLabel.setText(number + " is not a prime number.");
            }
        } catch (NumberFormatException ex) { // Handle exceptions if the input is not a valid number
            resultLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

    private boolean isPrime(int number) { // Define a private method to check if a number is prime
        if (number <= 1) { // Check if the number is less than or equal to 1 (not prime)
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) { // Iterate from 2 to the square root of the number
            if (number % i == 0) { // If the number is divisible by 'i', it's not prime
                return false;
            }
        }
        return true; // If no divisors are found, the number is prime
    }

    public static void main(String[] args) { // Main method
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PrimeNumberChecker().setVisible(true); // Create an instance of PrimeNumberChecker and make it visible
            }
        });
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessTheNumberGame extends JFrame {

    private static final int MAX_NUMBER = 100;
    private static final int MIN_NUMBER = 1;
    
    private int targetNumber;
    private int attempts;

    private JTextField guessInput;
    private JButton guessButton;
    private JLabel resultLabel;
    private JLabel attemptsLabel;

    public GuessTheNumberGame() {
        setTitle("Guess the Number Game");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        // Initialize components
        guessInput = new JTextField();
        guessButton = new JButton("Guess");
        resultLabel = new JLabel("Enter a number between 1 and 100:");
        attemptsLabel = new JLabel("Attempts: 0");

        // Add components to frame
        add(resultLabel);
        add(guessInput);
        add(guessButton);
        add(attemptsLabel);

        // Button click event
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGuess();
            }
        });

        // Initialize game
        startNewGame();
    }

    private void startNewGame() {
        Random random = new Random();
        targetNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
        attempts = 0;
        attemptsLabel.setText("Attempts: " + attempts);
        resultLabel.setText("Enter a number between 1 and 100:");
        guessInput.setText("");
        guessInput.requestFocus();
    }

    private void handleGuess() {
        try {
            int guess = Integer.parseInt(guessInput.getText());
            attempts++;
            attemptsLabel.setText("Attempts: " + attempts);

            if (guess < MIN_NUMBER || guess > MAX_NUMBER) {
                resultLabel.setText("Please enter a number between 1 and 100.");
            } else if (guess < targetNumber) {
                resultLabel.setText("Too low! Try again.");
            } else if (guess > targetNumber) {
                resultLabel.setText("Too high! Try again.");
            } else {
                resultLabel.setText("Congratulations! You guessed it right.");
                int response = JOptionPane.showConfirmDialog(this, "Play again?", "Game Over", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    startNewGame();
                } else {
                    System.exit(0);
                }
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input. Please enter a number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GuessTheNumberGame().setVisible(true);
        });
    }
}

package bullscows;

import java.util.Scanner;

import static bullscows.CodeGenerator.generateSecretCode;
import static bullscows.Grader.validateAnswer;

public class Game {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the length of the secret code:");
        String secretCodeLength = scanner.nextLine();
        try {
            int secretLength = Integer.parseInt(secretCodeLength);
            System.out.println("Input the number of possible symbols in the code:");
            int possibleSymbolLength = scanner.nextInt();
            if (secretLength == 0 || secretLength > possibleSymbolLength) {
                System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique " +
                                  "symbols.\n", secretLength, possibleSymbolLength);
            } else if (possibleSymbolLength > 36) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            } else {
                String secretCode = generateSecretCode(secretLength, possibleSymbolLength);
                System.out.println("Okay, let's start a game!");
                int turn = 1;
                boolean correct = false;
                while (!correct) {
                    System.out.printf("Turn %d:\n", turn);
                    String answer = scanner.next();
                    correct = validateAnswer(secretCode, answer);
                    turn++;
                }
                System.out.println("Congratulations! You guessed the secret code.");
            }
        } catch (Exception e) {
            System.out.printf("Error: \"%s\" isn't a valid number.", secretCodeLength);
        }
    }
}

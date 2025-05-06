package Mastermind;

import java.util.Scanner;

public class MastermindGame {
    private final CodeChecker checker;
    private final GameRepository repository;
    private final String secretCode;

    public MastermindGame(CodeChecker checker, GameRepository repository, String secretCode) {
        this.checker = checker;
        this.repository = repository;
        this.secretCode = secretCode;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        int attempts = 0;
        String guess;

        while (true) {
            System.out.print("Enter guess: ");
            guess = scanner.nextLine();
            if (!guess.matches("\\d{4}")) {
                System.out.println("Invalid input. Enter 4 digits.");
                continue;
            }

            attempts++;
            String feedback = checker.check(secretCode, guess);
            System.out.println(feedback);

            if (feedback.startsWith("4 correct")) {
                System.out.println("You guessed it in " + attempts + " attempts!");
                try {
                    repository.saveGame(new GameResult(name, attempts));
                } catch (Exception e) {
                    System.out.println("Error saving game: " + e.getMessage());
                }
                break;
            }
        }

        System.out.println("Top 3 games:");
        for (GameResult res : repository.getTopGames()) {
            System.out.println(res.getPlayerName() + ": " + res.getAttempts() + " attempts");
        }
    }
}


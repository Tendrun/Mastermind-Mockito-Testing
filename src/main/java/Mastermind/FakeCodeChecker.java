package Mastermind;

public class FakeCodeChecker implements CodeChecker {
    // Check which number is correct and misplaced
    @Override
    public String check(String secretCode, String guess) {
        int correct = 0, misplaced = 0;
        for (int i = 0; i < secretCode.length(); i++) {
            if (secretCode.charAt(i) == guess.charAt(i)) correct++;
            else if (secretCode.contains(String.valueOf(guess.charAt(i)))) misplaced++;
        }
        return correct + " correct, " + misplaced + " misplaced";
    }
}


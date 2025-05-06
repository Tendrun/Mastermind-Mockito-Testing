package Mastermind;

public class FakeCodeChecker implements CodeChecker {
    @Override
    public String check(String secretCode, String guess) {
        int exact = 0, partial = 0;
        for (int i = 0; i < secretCode.length(); i++) {
            if (secretCode.charAt(i) == guess.charAt(i)) exact++;
            else if (secretCode.contains(String.valueOf(guess.charAt(i)))) partial++;
        }
        return exact + " correct, " + partial + " misplaced";
    }
}


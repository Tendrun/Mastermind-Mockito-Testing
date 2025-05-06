package Mastermind;

public class Main {
    public static void main(String[] args) {
        CodeChecker checker = new FakeCodeChecker();
        FakeGameRepository repository = new FakeGameRepository();
        MastermindGame game = new MastermindGame(checker, repository, "1234");
        game.play();
    }
}
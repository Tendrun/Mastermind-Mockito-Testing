import Mastermind.FakeCodeChecker;
import Mastermind.FakeGameRepository;
import Mastermind.GameResult;
import Mastermind.MastermindGame;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MastermindGameTest {
    @Test
    public void testRepositoryFailure() {
        FakeGameRepository repo = new FakeGameRepository();
        repo.setShouldFail(true);
        MastermindGame game = new MastermindGame(new FakeCodeChecker(), repo, "1234");

        // Test przez sprawdzenie czy nie ma wyjątku (interakcja konsolowa nie testowana tu)
        try {
            repo.saveGame(new GameResult("Test", 5));
            fail("Exception expected");
        } catch (Exception e) {
            assertEquals("Database connection error", e.getMessage());
        }
    }
}

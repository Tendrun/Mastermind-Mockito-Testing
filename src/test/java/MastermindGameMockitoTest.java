import Mastermind.CodeChecker;
import Mastermind.GameRepository;
import Mastermind.GameResult;
import Mastermind.MastermindGame;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MastermindGameMockitoTest {
    @Test
    public void testTop3GamesFromRepository() throws Exception {
        GameRepository mockRepo = mock(GameRepository.class);
        when(mockRepo.getTopGames()).thenReturn(List.of(
                new GameResult("Anna", 3),
                new GameResult("Tom", 4),
                new GameResult("Zoe", 5)
        ));

        CodeChecker checker = mock(CodeChecker.class);
        when(checker.check("1234", "1234")).thenReturn("4 correct, 0 misplaced");

        MastermindGame game = new MastermindGame(checker, mockRepo, "1234");
        mockRepo.saveGame(new GameResult("Tester", 1));
        verify(mockRepo, times(1)).saveGame(any());

        assertEquals(3, mockRepo.getTopGames().size());
    }
}

package Mastermind;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FakeGameRepository implements GameRepository {
    // holds games to be saved or to be read
    private final List<GameResult> storage = new ArrayList<>();
    // Field to test program
    private boolean shouldFail = false;

    // Setter
    public void setShouldFail(boolean fail) {
        this.shouldFail = fail;
    }

    // Testing function
    // wyświetlenie 3 najlepszych rozgrywek w historii.
    @Override
    public void saveGame(GameResult result) throws Exception {
        if (shouldFail) throw new Exception("Database connection error");
        storage.add(result);
    }

    // read from file top 3 games
    @Override
    public List<GameResult> getTopGames() {
        return storage.stream()
                .sorted(Comparator.comparingInt(GameResult::getAttempts))
                .limit(3)
                .toList();
    }
}


package Mastermind;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FakeGameRepository implements GameRepository {
    private final List<GameResult> storage = new ArrayList<>();
    private boolean shouldFail = false;

    public void setShouldFail(boolean fail) {
        this.shouldFail = fail;
    }

    @Override
    public void saveGame(GameResult result) throws Exception {
        if (shouldFail) throw new Exception("Database connection error");
        storage.add(result);
    }

    @Override
    public List<GameResult> getTopGames() {
        return storage.stream()
                .sorted(Comparator.comparingInt(GameResult::getAttempts))
                .limit(3)
                .toList();
    }
}


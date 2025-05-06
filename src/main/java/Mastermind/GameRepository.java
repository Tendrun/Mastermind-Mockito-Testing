package Mastermind;

import java.util.List;

// Interface added to add possibility of abstraction
// Possibly there will be a real code
public interface GameRepository {
    void saveGame(GameResult result) throws Exception;
    List<GameResult> getTopGames();
}


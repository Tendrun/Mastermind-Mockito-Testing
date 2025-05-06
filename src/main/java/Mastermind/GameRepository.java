package Mastermind;

import java.util.List;

public interface GameRepository {
    void saveGame(GameResult result) throws Exception;
    List<GameResult> getTopGames();
}


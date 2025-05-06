package Mastermind;

public class GameResult {
    private final String playerName;
    private final int attempts;

    public GameResult(String playerName, int attempts) {
        this.playerName = playerName;
        this.attempts = attempts;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getAttempts() {
        return attempts;
    }
}

import GameEngine.State.GameState;
import World.Interfaces.ILevel;
import World.Levels.LevelOne;

public class Main {
    public static void main(String[] args) {
        ILevel level = new LevelOne();
        var gameState = new GameState(level);
        gameState.RunLevel();
    }
}

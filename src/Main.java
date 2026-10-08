import GameEngine.State.GameState;
import Services.LoggingService.ConsoleLogger;
import Services.LoggingService.Enums.InfoLevelEnum;
import World.Interfaces.ILevel;
import World.Levels.LevelOne;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ILevel level = new LevelOne();
        var gameState = new GameState(level);
        gameState.RunLevel();
    }
}

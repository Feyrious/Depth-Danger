import GameEngine.State.GameState;
import World.Interfaces.ILevel;
import World.Levels.LevelOne;

void main() {
    ILevel level = new LevelOne();
    var gameState = new GameState(level);
    gameState.RunLevel();
}


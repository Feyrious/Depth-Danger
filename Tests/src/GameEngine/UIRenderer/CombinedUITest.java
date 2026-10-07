package GameEngine.UIRenderer;

import Models.Actors.Player.Character;
import World.GameBoard;
import World.Levels.LevelOne;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CombinedUITest {
    //region Tests
    @Test
    @DisplayName("Render a complete scene with stats, map and legend for a player")
    void RenderMap_LevelOne_PrintsLevelToConsole() {
        // Arrange
        Character player = new Character(20, 20);
        player.LevelUp();
        player.LevelUp();
        player.LevelUp();
        player.SetCoins(20);
        LevelOne levelOne = new LevelOne();
        GameBoard game = new GameBoard(levelOne);

        // Act & Assert
        assertDoesNotThrow(() -> StatMenu.RenderStats(player));
        assertDoesNotThrow(() -> NavigationMap.RenderMap(game, null, null));
        assertDoesNotThrow(() -> Legend.RenderLegend());
    }
    //endregion
}

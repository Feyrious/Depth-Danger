package GameEngine.UIRenderer;

import Models.Actors.Player.Character;
import Services.UIServices.Renderer.Legend;
import Services.UIServices.Renderer.NavigationMap;
import Services.UIServices.Renderer.StatMenu;
import World.GameBoard;
import World.Interfaces.ILevel;
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
        Character player = new Character(1);
        player.LevelUp();
        player.LevelUp();
        player.LevelUp();
        player.CollectCoins(20);
        ILevel level1 = new LevelOne();
        GameBoard game = new GameBoard(level1);

        // Act & Assert
        assertDoesNotThrow(() -> StatMenu.RenderStats(player));
        assertDoesNotThrow(() -> NavigationMap.RenderMap(game, null, null));
        assertDoesNotThrow(() -> Legend.RenderLegend());
    }
    //endregion
}

package GameEngine.UIRenderer;

import Services.UIServices.Renderer.NavigationMap;
import World.GameBoard;
import World.Levels.Level1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class NavigationMapTest {

    //region Tests
    @Test
    @DisplayName("RenderMap should render LevelOne on the Board to console")
    void RenderMap_LevelOne_PrintsLevelToConsole() {
        // Arrange
        Level1 levelOne = new Level1();
        GameBoard game = new GameBoard(levelOne);

        // Act & Assert
        assertDoesNotThrow(() -> NavigationMap.RenderMap(game, null, null));
    }
    //endregion
}

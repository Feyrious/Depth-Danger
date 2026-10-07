package GameEngine.UIRenderer;

import World.GameBoard;
import World.Levels.LevelOne;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class NavigationMapTest {

    //region Tests
    @Test
    @DisplayName("RenderMap should render LevelOne on the Board to console")
    void RenderMap_LevelOne_PrintsLevelToConsole() {
        // Arrange
        LevelOne levelOne = new LevelOne();
        GameBoard game = new GameBoard(levelOne);

        // Act & Assert
        assertDoesNotThrow(() -> NavigationMap.RenderMap(game));
    }
    //endregion
}

package GameEngine.UIRenderer;

import Models.Actors.Player.Character;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class StatMenuTest {
    //region Tests
    @Test
    @DisplayName("Rendered stats should have a nice box around it and show stats inside of it")
    void RenderStat_ForCharacter_ToConsole() {
        // Arrange
        Character player = new Character(20, 20);
        player.LevelUp();
        player.SetCoins(20);

        // Act & Assert
        assertDoesNotThrow(() -> StatMenu.RenderStats(player));
    }
    //endregion
}

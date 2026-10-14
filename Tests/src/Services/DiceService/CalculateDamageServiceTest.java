package Services.DiceService;

import Models.Combat.Damage.Damage;
import Models.Combat.Damage.DamageTypeEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculateDamageServiceTest {

    //region Tests
    @Test
    @DisplayName("RollDamage should return static damage when damage amount is zero")
    void RollDamage_StaticDamageOnly_ReturnsStaticDamage() {
        // Arrange
        var die = new Dice(6);
        Damage damage = new Damage(die, 5, DamageTypeEnum.Physical);

        // Act
        int totalDamage = damage.RollForDamage();

        // Assert
        assertEquals(5, totalDamage);
    }

    @Test
    @DisplayName("RollDamage should return damage within expected range for one die plus static damage")
    void RollDamage_SingleDieWithStaticDamage_ReturnsDamageWithinRange() {
        // Arrange
        var dieDamage = new ArrayList<Dice>(List.of(
                new Dice(6)
        ));
        int staticDamage = 3;

        // Act
        for (int i = 0; i < 10; i++) {
            Damage damage = new Damage(dieDamage, staticDamage, DamageTypeEnum.Physical);
            int totalDamage = damage.RollForDamage();

            // Assert
            assertTrue(totalDamage >= 4 && totalDamage <= 9,
                    "Expected total damage to be within valid range, but got: " + totalDamage);
        }
    }

    @Test
    @DisplayName("RollDamage should return damage within expected range for several dies plus static damage")
    void RollDamage_MultipleDiesWithStaticDamage_ReturnsDamageWithinRange() {
        // Arrange
        var dieDamage = new ArrayList<Dice>(List.of(
                new Dice(6),
                new Dice(6),
                new Dice(6),
                new Dice(6),
                new Dice(6),
                new Dice(6)
        ));
        int staticDamage = 3;

        // Act
        for (int i = 0; i < 50; i++) {
            Damage damage = new Damage(dieDamage, staticDamage, DamageTypeEnum.Physical);
            int totalDamage = damage.RollForDamage();

            // Assert
            assertTrue(totalDamage >= 9 && totalDamage <= 39,
                    "Expected total damage to be within valid range, but got: " + totalDamage);
        }
    }
    //endregion
}
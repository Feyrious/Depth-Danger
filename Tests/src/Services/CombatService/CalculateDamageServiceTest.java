package Services.CombatService;

import Models.Combat.Damage.Damage;
import Models.Combat.Damage.DamageTypeEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculateDamageServiceTest {

    //region Tests
    @Test
    @DisplayName("RollDamage should return static damage when damage amount is zero")
    void RollDamage_StaticDamageOnly_ReturnsStaticDamage() {
        // Arrange
        Damage damage = new Damage(0, 6, 5, DamageTypeEnum.Physical);

        // Act
        int totalDamage = CalculateDamageService.RollDamage(damage);

        // Assert
        assertEquals(5, totalDamage);
    }

    @Test
    @DisplayName("RollDamage should return damage within expected range for one die plus static damage")
    void RollDamage_SingleDieWithStaticDamage_ReturnsDamageWithinRange() {
        // Arrange
        int damageAmount = 1;
        int damageSize = 6;
        int staticDamage = 3;

        // Act
        for (int i = 0; i < 10; i++) {
            Damage damage = new Damage(damageAmount, damageSize, staticDamage, DamageTypeEnum.Physical);
            int totalDamage = CalculateDamageService.RollDamage(damage);

            // Assert
            assertTrue(totalDamage >= 4 && totalDamage <= 9,
                    "Expected total damage to be within valid range, but got: " + totalDamage);
        }
    }

    @Test
    @DisplayName("RollDamage should return damage within expected range for several dies plus static damage")
    void RollDamage_MultipleDiesWithStaticDamage_ReturnsDamageWithinRange() {
        // Arrange
        int damageAmount = 6;
        int damageSize = 6;
        int staticDamage = 3;

        // Act
        for (int i = 0; i < 50; i++) {
            Damage damage = new Damage(damageAmount, damageSize, staticDamage, DamageTypeEnum.Physical);
            int totalDamage = CalculateDamageService.RollDamage(damage);

            // Assert
            assertTrue(totalDamage >= 9 && totalDamage <= 39,
                    "Expected total damage to be within valid range, but got: " + totalDamage);
        }
    }
    //endregion
}
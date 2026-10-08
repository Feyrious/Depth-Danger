package GameEngine.CombatService;

import Models.Combat.Damage.Damage;
import Services.LoggingService.ConsoleLogger;
import Services.LoggingService.Enums.InfoLevelEnum;

import java.util.Random;

public class CalculateDamageService {
    private static Random rand = new Random();
    
    public static int RollDamage(Damage damage) {
        int total = 0;

        for (int i = 0; i < damage.GetDamageAmount(); i++) {
            total += rand.nextInt(1, damage.GetDamageSize());
            ConsoleLogger.LogInfo(InfoLevelEnum.DEBUG, total);
        }

        total += damage.GetStaticDamage();

        return total;
    }
}

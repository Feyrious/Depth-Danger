package Services.CombatService;

import Models.Combat.Damage.Damage;
import Services.LoggingService.ConsoleLogger;
import Services.LoggingService.Enums.InfoLevelEnum;
import Services.LoggingService.ILogger;

import java.util.Random;

public class CalculateDamageService {
    private static Random rand = new Random();
    private static ILogger logger = new ConsoleLogger();
    
    private static int RollDamage(Damage damage) {
        int total = 0;

        for (int i = 0; i < damage.GetDamageAmount(); i++) {
            total += rand.nextInt(1, damage.GetDamageSize());
            logger.LoggInfo(InfoLevelEnum.DEBUG, total);
        }

        total += damage.GetStaticDamage();

        return total;
    }
}

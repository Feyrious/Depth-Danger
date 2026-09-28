package Services.CombatService;

import Models.Combat.Damage.Damage;
import Services.LoggingService.ConsoleLogger;
import Services.LoggingService.ILogger;

import java.util.Random;

public class CalculateDamageService {
    private static Random rand = new Random();
    
    private static int RollDamage(Damage damage) {
        int total = 0;

        for (int i = 0; i < damage.GetDamageAmount(); i++) {
            total += rand.nextInt(1, damage.GetDamageSize());

        }

        total += damage.GetStaticDamage();

        return total;
    }
}

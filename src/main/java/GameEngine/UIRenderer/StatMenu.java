package GameEngine.UIRenderer;
import Models.Actors.Player.Character;
import Services.LoggingService.ConsoleLogger;

public class StatMenu {

    public static void RenderStats(Character character) {
        String healthMessage = "HP: " + String.format("%03d", character.GetCurrentHealth()) + "/" + String.format("%03d", character.GetMaxHealth()) + " - ";
        String coinsMessage = "Coins: " + String.format("%04d", character.GetCoins()) + " - ";
        String levelMessage = "Level: " + String.format("%02d", character.GetCurrentLevel());
        String message = healthMessage + coinsMessage + levelMessage;

        System.out.println("╭───────────────────────────────────────╮");
        System.out.println("│ " + message + " │");
        if (ConsoleLogger._inDebugMode)
            System.out.println("│ Player Current Position - X: " + String.format("%02d", character.GetCurrentX()) + " Y: " + String.format("%02d", character.GetCurrentY()) + " │");
        System.out.println("╰───────────────────────────────────────╯");
    }
}

package Services.UIServices.Renderer;
import Models.Actors.Player.Character;

public class StatMenu {

    public static void RenderStats(Character character) {
        String healthMessage = "HP: " + String.format("%03d", character.GetCurrentHitPoints()) + "/" + String.format("%03d", character.GetMaxHitPoints()) + "    -    ";
        String coinsMessage = "Coins: " + String.format("%04d", character.CountCoins()) + "    -    ";
        String levelMessage = "Level: " + String.format("%02d", character.GetCurrentLevel());
        String message = healthMessage + coinsMessage + levelMessage;

        System.out.println("   ╭──────────────────────────────────────────────────────────────╮");
        System.out.println("   │      " + message + "       │");
        System.out.println("   ╰──────────────────────────────────────────────────────────────╯");
    }
}

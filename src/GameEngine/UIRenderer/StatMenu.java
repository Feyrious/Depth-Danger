package GameEngine.UIRenderer;
import Models.Actors.Player.Character;

public class StatMenu {

    public static void PrintStats(Character character) {
        System.out.println("HP: " + character.GetCurrentHealth() + "/" + character.GetMaxHealth());

    }
}

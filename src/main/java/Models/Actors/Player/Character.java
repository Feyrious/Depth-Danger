package Models.Actors.Player;

import Models.Actors.Creature;
import Models.Actors.LevelEntity;
import Models.Items.Item;
import Models.Items.Treasure;
import Services.LoggingService.ConsoleLogger;

import java.util.ArrayList;

public class Character extends Creature {
    private int _level;
    private int _coins;

    public void CollectCoins(int coins) {
        this._coins += coins;
    }

    public int CountCoins() {
        return this._coins;
    }

    private void SetLevel(int level) {
        this._level = level;
    }

    public int GetCurrentLevel() {
        return this._level;
    }

    public Character(int characterLevel) {
        super(characterLevel * 5, characterLevel * 5);
        this._currentX = 2;
        this._currentY = 2;
        this._level = characterLevel;
    }

    public void LevelUp() {
        this._level++;
        super._maxHitPoints += 5;
        super._currentHitPoints += 5;
    }

    public void Collect(Treasure treasure) {
        var coins = treasure.CollectCoins();
        var items = treasure.CollectItems();

        if (coins > 0) {
            CollectCoins(coins);
            ConsoleLogger.LogGameMessage("You picked up " + coins + " Coins!" );
        }

        if (items.size() > 0) {
            CollectItems(items);
            for (Item item : items) {
                ConsoleLogger.LogGameMessage("You picked up a " + item.GetName() + "!" );
            }
        }
    }
}

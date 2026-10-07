package Models.Actors.Player;

import Models.Actors.Entity;

public class Character extends Entity {
    private int _level;
    private int _coins;

    public void SetCoins(int coins) {
        this._coins = coins;
    }

    public int GetCoins() {
        return this._coins;
    }

    private void SetLevel(int level) {
        this._level = level;
    }

    public int GetCurrentLevel() {
        return this._level;
    }

    public Character(int currentHitPoints, int maxHitPoints) {
        super(currentHitPoints, maxHitPoints, 1);
        this._currentX = 2;
        this._currentY = 2;
    }

    public int GetCurrentHealth() {
        return super._currentHitPoints;
    }

    public int GetMaxHealth() {
        return super._maxHitPoints;
    }

    public void LevelUp() {
        this._level++;
        super._maxHitPoints += 10;
        super._currentHitPoints = super._maxHitPoints;
    }
}

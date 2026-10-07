package Models.Actors.Player;

import Models.Actors.Entity;

public class Character extends Entity {
    private int _level;

    public void SetLevel(int level) {
        this._level = level;
    }

    public Character(int currentHitPoints, int maxHitPoints, int level) {
        super(currentHitPoints, maxHitPoints, level);
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

package Models;

public class Entity {
    private int _hitPoints;

    public void SetHitPoints(int damage) {
        this._hitPoints = this._hitPoints - damage;

        if (this._hitPoints < 0)
            this._hitPoints = 0;
    }

    public int GetHitPoints() {
        return this._hitPoints;
    }
}
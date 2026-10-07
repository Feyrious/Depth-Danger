package Models.Actors;

public class Entity {

    //region Properties

    protected int _currentHitPoints;
    protected int _maxHitPoints;

    public int GetHitPoints() {
        return this._currentHitPoints;
    }
    //endregion


    public Entity(int currentHitPoints, int maxHitPoints, int level) {
        this._currentHitPoints = currentHitPoints;
        this._maxHitPoints = maxHitPoints;
    }

    public void TakeDamage(int damage) {
        this._currentHitPoints -= damage;

        if (this._currentHitPoints < 0)
            this._currentHitPoints = 0;
    }
}
package Models.Actors;

public class Entity {

    //region Properties

    protected int _currentHitPoints;
    protected int _maxHitPoints;
    protected int _currentX;
    protected int _currentY;

    public int GetCurrentX() {
        return this._currentX;
    }

    public int GetCurrentY() {
        return this._currentY;
    }

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

    public void MoveUp() {
        this._currentY--;
    }

    public void MoveDown() {
        this._currentY++;
    }

    public void MoveLeft() {
        this._currentX--;
    }

    public void MoveRight() {
        this._currentX++;
    }
}
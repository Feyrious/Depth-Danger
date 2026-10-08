package Models.Actors;

import Models.Actors.Interfaces.IMovable;

public class Entity implements IMovable {

    //region Properties

    protected int _currentHitPoints;
    protected int _maxHitPoints;
    protected int _currentX;
    protected int _currentY;

    @Override
    public int GetCurrentX() {
        return this._currentX;
    }

    @Override
    public int GetCurrentY() {
        return this._currentY;
    }

    public int GetHitPoints() {
        return this._currentHitPoints;
    }
    //endregion


    public Entity(int currentHitPoints, int maxHitPoints) {
        this._currentHitPoints = currentHitPoints;
        this._maxHitPoints = maxHitPoints;
    }

    public void TakeDamage(int damage) {
        this._currentHitPoints -= damage;

        if (this._currentHitPoints < 0)
            this._currentHitPoints = 0;
    }

    public void SetStartPosition(int x, int y) {
        this._currentX = x;
        this._currentY = y;
    }

    @Override
    public void MoveUp() {
        this._currentY--;
    }

    @Override
    public void MoveDown() {
        this._currentY++;
    }

    @Override
    public void MoveLeft() {
        this._currentX--;
    }

    @Override
    public void MoveRight() {
        this._currentX++;
    }
}

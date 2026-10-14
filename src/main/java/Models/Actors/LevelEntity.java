package Models.Actors;

import Models.Actors.Interfaces.IMovable;

public class LevelEntity {

    //region Properties
    protected int _currentX;
    protected int _currentY;

    public int GetCurrentX() {
        return this._currentX;
    }

    public int GetCurrentY() {
        return this._currentY;
    }

    public void SetStartPosition(int x, int y) {
        this._currentX = x;
        this._currentY = y;
    }

}

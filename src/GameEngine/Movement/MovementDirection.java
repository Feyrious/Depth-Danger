package GameEngine.Movement;

public class MovementDirection {
    private int _headingDirection;       // 0: Up, 1: Right, 2: Down, 3: Left
    private int _horizontalDirection;    // 1: Right, -1: Left (for search pattern)
    private int _verticalDirection;      // 1: Down, -1: Up (for search pattern)

    public MovementDirection() {
        this._headingDirection = 1;
        this._horizontalDirection = 1;
        this._verticalDirection = 1;
    }

    public MovementDirection(int headingDirection, int horizontalDirection, int verticalDirection) {
        this._headingDirection = headingDirection;
        this._horizontalDirection = horizontalDirection;
        this._verticalDirection = verticalDirection;
    }

    public int GetHeadingDirection() {
        return this._headingDirection;
    }

    public void SetHeadingDirection(int headingDirection) {
        this._headingDirection = headingDirection;
    }

    public int GetHorizontalDirection() {
        return this._horizontalDirection;
    }

    public void SetHorizontalDirection(int horizontalDirection) {
        this._horizontalDirection = horizontalDirection;
    }

    public int GetVerticalDirection() {
        return this._verticalDirection;
    }

    public void SetVerticalDirection(int verticalDirection) {
        this._verticalDirection = verticalDirection;
    }
}

package GameEngine.Movement.Patterns;

import Models.Actors.Monsters.BaseMonster;
import World.GameBoard;

public class BaseMovementPattern {
    protected boolean canMoveInDirection(GameBoard board, int x, int y, int direction) {
        switch (direction) {
            case 0: // Up
                return y > 0 && board.IsWalkable(x, y - 1);
            case 1: // Right
                return x < board.GetWidth() - 1 && board.IsWalkable(x + 1, y);
            case 2: // Down
                return y < board.GetHeight() - 1 && board.IsWalkable(x, y + 1);
            case 3: // Left
                return x > 0 && board.IsWalkable(x - 1, y);
            default:
                return false;
        }
    }

    protected void executeDirectionMove(BaseMonster monster, int direction) {
        switch (direction) {
            case 0:
                monster.MoveUp();
                break;
            case 1:
                monster.MoveRight();
                break;
            case 2:
                monster.MoveDown();
                break;
            case 3:
                monster.MoveLeft();
                break;
            default:
                break;
        }
    }
}

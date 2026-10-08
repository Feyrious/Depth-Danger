package GameEngine.Movement.Patterns;

import GameEngine.Movement.Interfaces.IMonsterMovementStrategy;
import GameEngine.Movement.MovementDirection;
import Models.Actors.Monsters.BaseMonster;
import World.GameBoard;

public class PatrolMovementPattern implements IMonsterMovementStrategy {

    @Override
    public void Move(BaseMonster monster, GameBoard board) {
        if (monster == null || board == null) {
            return;
        }

        MovementDirection directionState = monster.GetMovementDirection();
        if (directionState == null) {
            directionState = new MovementDirection();
            monster.SetMovementDirection(directionState);
        }

        int currentX = monster.GetCurrentX();
        int currentY = monster.GetCurrentY();
        int heading = directionState.GetHeadingDirection();

        if (canMoveInDirection(board, currentX, currentY, heading)) {
            executeDirectionMove(monster, heading);
        } else {
            // Turn clockwise to find the next walkable direction: (heading + 1) % 4, (heading + 2) % 4, (heading + 3) % 4
            for (int offset = 1; offset <= 3; offset++) {
                int nextHeading = (heading + offset) % 4;
                if (canMoveInDirection(board, currentX, currentY, nextHeading)) {
                    directionState.SetHeadingDirection(nextHeading);
                    executeDirectionMove(monster, nextHeading);
                    return;
                }
            }
        }
    }

    private boolean canMoveInDirection(GameBoard board, int x, int y, int direction) {
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

    private void executeDirectionMove(BaseMonster monster, int direction) {
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

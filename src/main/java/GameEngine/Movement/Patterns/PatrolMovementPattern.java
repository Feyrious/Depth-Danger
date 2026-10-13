package GameEngine.Movement.Patterns;

import GameEngine.Movement.Interfaces.IMonsterMovementStrategy;
import GameEngine.Movement.MovementDirection;
import Models.Actors.Monsters.BaseMonster;
import World.GameBoard;

public class PatrolMovementPattern extends BaseMovementPattern implements IMonsterMovementStrategy {

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
}

package GameEngine.Movement.Patterns;

import GameEngine.Movement.Interfaces.IMonsterMovementStrategy;
import GameEngine.Movement.MovementDirection;
import Models.Actors.Monsters.BaseMonster;
import World.GameBoard;

public class SearchMovementPattern implements IMonsterMovementStrategy {

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
        int hDir = directionState.GetHorizontalDirection(); // 1: Right, -1: Left
        int vDir = directionState.GetVerticalDirection();   // 1: Down, -1: Up

        // Try moving horizontally
        if (hDir == 1 && currentX < board.GetWidth() - 1 && board.IsWalkable(currentX + 1, currentY)) {
            monster.MoveRight();
            return;
        } else if (hDir == -1 && currentX > 0 && board.IsWalkable(currentX - 1, currentY)) {
            monster.MoveLeft();
            return;
        }

        // Horizontal move is blocked: attempt a vertical step to the next row/column and reverse horizontal direction
        boolean steppedVertically = false;

        if (vDir == 1 && currentY < board.GetHeight() - 1 && board.IsWalkable(currentX, currentY + 1)) {
            monster.MoveDown();
            steppedVertically = true;
        } else if (vDir == -1 && currentY > 0 && board.IsWalkable(currentX, currentY - 1)) {
            monster.MoveUp();
            steppedVertically = true;
        } else {
            // Reached top/bottom boundary: reverse vertical direction and try again
            int reversedVDir = -vDir;
            directionState.SetVerticalDirection(reversedVDir);
            if (reversedVDir == 1 && currentY < board.GetHeight() - 1 && board.IsWalkable(currentX, currentY + 1)) {
                monster.MoveDown();
                steppedVertically = true;
            } else if (reversedVDir == -1 && currentY > 0 && board.IsWalkable(currentX, currentY - 1)) {
                monster.MoveUp();
                steppedVertically = true;
            }
        }

        // Reverse horizontal direction for the next sweep
        directionState.SetHorizontalDirection(-hDir);

        // If vertical step was not possible (e.g. single row corridor), try moving in reversed horizontal direction
        if (!steppedVertically) {
            int newHDir = directionState.GetHorizontalDirection();
            if (newHDir == 1 && currentX < board.GetWidth() - 1 && board.IsWalkable(currentX + 1, currentY)) {
                monster.MoveRight();
            } else if (newHDir == -1 && currentX > 0 && board.IsWalkable(currentX - 1, currentY)) {
                monster.MoveLeft();
            }
        }
    }
}

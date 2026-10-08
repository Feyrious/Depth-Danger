package GameEngine.Movement.Patterns;

import GameEngine.Movement.Interfaces.IMonsterMovementStrategy;
import Models.Actors.Monsters.BaseMonster;
import World.GameBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMovementPattern implements IMonsterMovementStrategy {
    private static final Random random = new Random();

    @Override
    public void Move(BaseMonster monster, GameBoard board) {
        if (monster == null || board == null) {
            return;
        }

        int currentX = monster.GetCurrentX();
        int currentY = monster.GetCurrentY();

        List<Integer> possibleDirections = new ArrayList<>();

        // 0: Up, 1: Down, 2: Left, 3: Right
        if (currentY > 0 && board.IsWalkable(currentX, currentY - 1)) {
            possibleDirections.add(0);
        }
        if (currentY < board.GetHeight() - 1 && board.IsWalkable(currentX, currentY + 1)) {
            possibleDirections.add(1);
        }
        if (currentX > 0 && board.IsWalkable(currentX - 1, currentY)) {
            possibleDirections.add(2);
        }
        if (currentX < board.GetWidth() - 1 && board.IsWalkable(currentX + 1, currentY)) {
            possibleDirections.add(3);
        }

        if (!possibleDirections.isEmpty()) {
            int direction = possibleDirections.get(random.nextInt(possibleDirections.size()));
            switch (direction) {
                case 0:
                    monster.MoveUp();
                    break;
                case 1:
                    monster.MoveDown();
                    break;
                case 2:
                    monster.MoveLeft();
                    break;
                case 3:
                    monster.MoveRight();
                    break;
                default:
                    break;
            }
        }
    }
}

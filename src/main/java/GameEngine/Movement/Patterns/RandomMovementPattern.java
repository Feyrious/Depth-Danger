package GameEngine.Movement.Patterns;

import GameEngine.Movement.Interfaces.IMonsterMovementStrategy;
import Models.Actors.Monsters.BaseMonster;
import World.GameBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMovementPattern extends BaseMovementPattern implements IMonsterMovementStrategy {
    private static final Random random = new Random();

    @Override
    public void Move(BaseMonster monster, GameBoard board) {
        if (monster == null || board == null) {
            return;
        }

        int currentX = monster.GetCurrentX();
        int currentY = monster.GetCurrentY();

        int direction = random.nextInt(0,4);

        if (this.canMoveInDirection(board, currentX, currentY, direction)){
            this.executeDirectionMove(monster, direction);
        }
    }
}

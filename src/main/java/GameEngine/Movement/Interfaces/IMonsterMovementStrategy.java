package GameEngine.Movement.Interfaces;

import Models.Actors.Monsters.BaseMonster;
import World.GameBoard;

public interface IMonsterMovementStrategy {
    void Move(BaseMonster monster, GameBoard board);
}

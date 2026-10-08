package Models.Actors.Monsters;

import GameEngine.Movement.MovementDirection;
import Models.Actors.Entity;
import Models.Actors.Monsters.Enums.MonsterMovementTypeEnum;

public class BaseMonster extends Entity {
    protected MonsterMovementTypeEnum _movementPattern;
    protected MovementDirection _movementDirection;

    public MonsterMovementTypeEnum GetMovementPattern() {
        return this._movementPattern;
    }

    public void SetMovementPattern(MonsterMovementTypeEnum movementPattern) {
        this._movementPattern = movementPattern;
    }

    public MovementDirection GetMovementDirection() {
        return this._movementDirection;
    }

    public void SetMovementDirection(MovementDirection movementDirection) {
        this._movementDirection = movementDirection;
    }

    public BaseMonster(int currentHitPoints, int maxHitPoints) {
        super(currentHitPoints, maxHitPoints);
        this._movementPattern = MonsterMovementTypeEnum.Random;
        this._movementDirection = new MovementDirection();
    }

    public BaseMonster(int currentHitPoints, int maxHitPoints, MonsterMovementTypeEnum movementPattern) {
        super(currentHitPoints, maxHitPoints);
        this._movementPattern = movementPattern;
        this._movementDirection = new MovementDirection();
    }
}

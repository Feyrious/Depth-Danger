package Models.Actors.Monsters;

import GameEngine.Movement.MovementDirection;
import Models.Actors.Creature;
import Models.Actors.Monsters.Enums.MonsterMovementTypeEnum;
import Models.Actors.Player.Character;
import Models.Combat.Damage.Damage;
import Models.Combat.Damage.DamageTypeEnum;
import Services.DiceService.Dice;
import Services.LoggingService.ConsoleLogger;

public class BaseMonster extends Creature {
    protected MonsterMovementTypeEnum _movementPattern;
    protected MovementDirection _movementDirection;

    protected Damage _attack;

    private Damage Attack() {
        return _attack;
    }

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
        this._attack = new Damage(new Dice(0), 0, DamageTypeEnum.Physical);
    }

    public BaseMonster(int currentHitPoints, int maxHitPoints, MonsterMovementTypeEnum movementPattern) {
        super(currentHitPoints, maxHitPoints);
        this._movementPattern = movementPattern;
        this._movementDirection = new MovementDirection();
    }

    public void Attack(Character character) {
        var rolledDamage = this.Attack().RollForDamage();
        ConsoleLogger.LogGameMessage("The " + this.getClass().getSimpleName() + " attacked you for " + rolledDamage + " damage.");
        character.TakeDamage(rolledDamage);
    }
}

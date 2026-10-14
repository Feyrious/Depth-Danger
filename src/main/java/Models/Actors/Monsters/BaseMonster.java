package Models.Actors.Monsters;

import GameEngine.Movement.MovementDirection;
import Models.Actors.Entity;
import Models.Actors.Monsters.Enums.MonsterMovementTypeEnum;
import Models.Actors.Player.Character;
import Models.Combat.Damage.Damage;
import Models.Combat.Damage.DamageTypeEnum;
import Services.CombatService.CalculateDamageService;
import Services.LoggingService.ConsoleLogger;

public class BaseMonster extends Entity {
    protected MonsterMovementTypeEnum _movementPattern;
    protected MovementDirection _movementDirection;

    protected Damage _attackDamage;

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
        this._attackDamage = new Damage(0, 0, 1, DamageTypeEnum.Physical);
    }

    public BaseMonster(int currentHitPoints, int maxHitPoints, MonsterMovementTypeEnum movementPattern) {
        super(currentHitPoints, maxHitPoints);
        this._movementPattern = movementPattern;
        this._movementDirection = new MovementDirection();
    }

    public void Attack(Character character) {
        var rolledDamage = CalculateDamageService.RollDamage(this._attackDamage);
        ConsoleLogger.LogGameMessage("The " + this.getClass().getSimpleName() + " attacked you for " + rolledDamage + " damage.");
        character.TakeDamage(rolledDamage);
    }
}

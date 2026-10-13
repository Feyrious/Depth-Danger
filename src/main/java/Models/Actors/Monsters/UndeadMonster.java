package Models.Actors.Monsters;

import Models.Actors.Monsters.Enums.MonsterMovementTypeEnum;

public class UndeadMonster extends BaseMonster {
    public UndeadMonster(int currentHitPoints, int maxHitPoints) {
        super(currentHitPoints, maxHitPoints, MonsterMovementTypeEnum.Search);
    }

    public UndeadMonster(int currentHitPoints, int maxHitPoints, MonsterMovementTypeEnum movementPattern) {
        super(currentHitPoints, maxHitPoints, movementPattern);
    }
}

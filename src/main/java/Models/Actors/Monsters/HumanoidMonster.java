package Models.Actors.Monsters;

import Models.Actors.Monsters.Enums.MonsterMovementTypeEnum;

public class HumanoidMonster extends BaseMonster {
    public HumanoidMonster(int currentHitPoints, int maxHitPoints) {
        super(currentHitPoints, maxHitPoints, MonsterMovementTypeEnum.Patrol);
    }

    public HumanoidMonster(int currentHitPoints, int maxHitPoints, MonsterMovementTypeEnum movementPattern) {
        super(currentHitPoints, maxHitPoints, movementPattern);
    }
}

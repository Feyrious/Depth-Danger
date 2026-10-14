package Models.Actors.Monsters.Humanoids;

import Models.Actors.Monsters.HumanoidMonster;
import Models.Combat.Damage.Damage;
import Models.Combat.Damage.DamageTypeEnum;

public class Goblin extends HumanoidMonster {
    public Goblin() {
        super(5, 5);
        this._attackDamage = new Damage(1, 6, 0, DamageTypeEnum.Physical);
    }
}

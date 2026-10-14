package Models.Actors.Monsters.Humanoids;

import Models.Actors.Monsters.HumanoidMonster;
import Models.Combat.Damage.Damage;
import Models.Combat.Damage.DamageTypeEnum;
import Services.DiceService.Dice;

public class Goblin extends HumanoidMonster {
    public Goblin() {
        super(5, 5);
        var damageDie = new Dice(6);
        this._attack = new Damage(damageDie, 0, DamageTypeEnum.Physical);
    }
}

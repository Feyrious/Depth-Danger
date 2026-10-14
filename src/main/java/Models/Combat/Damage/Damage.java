package Models.Combat.Damage;

import Services.DiceService.Dice;

import java.util.ArrayList;

public class Damage {
    //region Class Properties
    private DamageTypeEnum _damageType;
    private ArrayList<Dice> _damageAmount;
    private int _staticDamage;

    public void SetStaticDamage(int staticDamage) {
        this._staticDamage = staticDamage;
    }

    public int GetStaticDamage() {
        return this._staticDamage;
    }

    public void SetDamageAmount(ArrayList<Dice> damageAmount) {
        this._damageAmount = damageAmount;
    }

    public int RollForDamage() {
        int damageValue = 0;

        for (Dice dice : this._damageAmount) {
            damageValue += dice.Roll();
        }

        damageValue += _staticDamage;

        return damageValue;
    }

    public void SetDamageType(DamageTypeEnum damageType) {
        this._damageType = damageType;
    }

    public DamageTypeEnum GetDamageType() {
        return this._damageType;
    }
    //endregion

    //region Class Constructors
    public Damage(Dice damageAmount, int staticDamage, DamageTypeEnum damageType) {
        this._damageAmount.add(damageAmount);
        this._damageType = damageType;
    }

    public Damage(ArrayList<Dice> damageAmount, int staticDamage, DamageTypeEnum damageType) {
        this._damageAmount = damageAmount;
        this._damageType = damageType;
    }
    //endregion


}

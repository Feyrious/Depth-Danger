package Models.Combat.Damage;

public class Damage {
    private DamageTypeEnum _type;
    private int _value;

    public void SetValue(int Value) {
        this._value = Value;
    }

    public int GetValue() {
        return this._value;
    }

    public void SetDamageType(DamageTypeEnum damageType) {
        this._type = damageType;
    }

    public DamageTypeEnum GetDamageType() {
        return this._type;
    }
}

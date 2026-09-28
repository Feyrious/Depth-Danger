package Models.Combat.Damage;

public class Damage {
    //region Class Properties
    private DamageTypeEnum _damageType;
    private int _damageSize;
    private int _damageAmount;
    private int _staticDamage;

    public void SetStaticDamage(int staticDamage) {
        this._staticDamage = staticDamage;
    }

    public int GetStaticDamage() {
        return this._staticDamage;
    }

    public void SetDamageAmount(int damageAmount) {
        this._damageAmount = damageAmount;
    }

    public int GetDamageAmount() {
        return this._damageAmount;
    }

    public void SetDamageSize(int damageSize) {
        this._damageSize = damageSize;
    }

    public int GetDamageSize() {
        return this._damageSize;
    }

    public void SetDamageType(DamageTypeEnum damageType) {
        this._damageType = damageType;
    }

    public DamageTypeEnum GetDamageType() {
        return this._damageType;
    }
    //endregion

    //region Class Constructors
    public Damage(int damageAmount, int damageSize, int staticDamage, DamageTypeEnum damageType) {
        this._damageAmount = damageAmount;
        this._damageSize = damageSize;
        this._damageType = damageType;
        this._staticDamage = staticDamage;
    }
    //endregion


}

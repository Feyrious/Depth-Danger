package Models.Items.Weapons;

import Models.Combat.Damage.Damage;

abstract public class BaseWeapon {
    //region Class Properties
    private Damage _weaponDamage;

    public void SetWeaponDamage(Damage weaponDamage) {
        this._weaponDamage = weaponDamage;
    }

    public Damage GetWeaponDamage() {
        return this._weaponDamage;
    }
    //endregion

    //region Class Constructors

    //endregion

    public
}

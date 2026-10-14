package Models.Items.Weapons;

import Models.Combat.Damage.Damage;
import Models.Items.Item;

abstract public class BaseWeapon extends Item {
    //region Class Properties
    private Damage _weaponDamage;

    public BaseWeapon(int _amount, String _name) {
        super(_amount, _name);
    }

    public void SetWeaponDamage(Damage weaponDamage) {
        this._weaponDamage = weaponDamage;
    }

    public Damage GetWeaponDamage() {
        return this._weaponDamage;
    }
    //endregion

    //region Class Constructors

    //endregion
}

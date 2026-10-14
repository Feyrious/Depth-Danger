package Models.Items.Armor;

import Models.Items.Item;

public class BaseArmor extends Item {
    private int _armorValue;

    public void SetArmorValue(int armorValue) {
        this._armorValue = armorValue;
    }

    public int GetArmorValue() {
        return this._armorValue;
    }

    public BaseArmor(int _amount, String _name) {
        super(_amount, _name);
    }
}

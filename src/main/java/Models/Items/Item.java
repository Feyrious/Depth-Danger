package Models.Items;

import Models.Items.Armor.BaseArmor;
import Models.Items.Potions.BasePotion;
import Models.Items.Weapons.BaseWeapon;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private int _amount;
    private String _name;

    public void SetAmount(int amount) {
        this._amount = amount;
    }

    public int GetAmount() {
        return this._amount;
    }

    public String GetName() {
        return this._name;
    }

    public Item(int _amount, String _name) {
        this._amount = _amount;
        this._name = _name;
    }

    public static ArrayList<BaseArmor> GetArmorFrom(ArrayList<Item> items){
        var armorItems = new ArrayList<BaseArmor>();

        for (Item item : items) {
            if (item instanceof BaseArmor)
                armorItems.add((BaseArmor) item);
        }

        return armorItems;
    }

    public static ArrayList<BasePotion> GetPotionFrom(ArrayList<Item> items){
        var potionItems = new ArrayList<BasePotion>();

        for (Item item : items) {
            if (item instanceof BasePotion)
                potionItems.add((BasePotion) item);
        }

        return potionItems;
    }

    public static ArrayList<BaseWeapon> GetWeaponFrom(ArrayList<Item> items){
        var weaponItems = new ArrayList<BaseWeapon>();

        for (Item item : items) {
            if (item instanceof BaseWeapon)
                weaponItems.add((BaseWeapon) item);
        }

        return weaponItems;
    }
}

package Models.Items;

import Models.Items.Armor.BaseArmor;
import Models.Items.Potions.BasePotion;
import Models.Items.Weapons.BaseWeapon;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private String _name;

    public String GetName() {
        return this._name;
    }

    public Item(String name) {
        this._name = name;
    }

    public static <T extends Item> ArrayList<T> GetItemsFrom(ArrayList<Item> items, Class<T> type){
        // 1. Safe null and empty check (using items.isEmpty() is preferred over stream().count())
        if (items == null || items.isEmpty()) {
            return null;
        }
        ArrayList<T> filteredItems = new ArrayList<>();

        for (Item item : items) {
            // 2. Use the Class token to check the type dynamically
            if (type.isInstance(item)) {
                // 3. Use the Class token to safely cast the item
                filteredItems.add(type.cast(item));
            }
        }

        return filteredItems;
    }
}

package Models.Items;

import Models.Actors.LevelEntity;

import java.util.ArrayList;

public class Treasure extends LevelEntity {
    private int _coins;

    private ArrayList<Item> _items = new ArrayList<>();

    public Treasure(int _coins, ArrayList<Item> _items) {
        this.SetCoins(_coins);
        this.SetItems(_items);
    }

    private void SetItems(ArrayList<Item> items) {
        if (items != null)
            this._items.addAll(items);
    }

    public ArrayList<Item> CollectItems() {
        var itemsToGive = this._items;
        this._items = new ArrayList<>();
        return itemsToGive;
    }

    private void SetCoins(int coins) {
        this._coins = coins;
    }

    public int CollectCoins() {
        int coinsToGive = this._coins;
        this._coins = 0;
        return coinsToGive;
    }
}

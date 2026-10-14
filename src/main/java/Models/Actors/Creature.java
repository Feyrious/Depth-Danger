package Models.Actors;

import Models.Actors.Interfaces.IMovable;
import Models.Items.Armor.BaseArmor;
import Models.Items.Item;

import java.util.ArrayList;
import java.util.Comparator;

public class Creature extends LevelEntity implements IMovable {
    protected int _currentHitPoints;
    protected int _maxHitPoints;

    private ArrayList<Item> _items;

    public void CollectItems(ArrayList<Item> items) {
        if (items != null)
            this._items.addAll(items);
    }

    public ArrayList<Item> GetItems() {
        return this._items;
    }

    public int GetCurrentHitPoints() {
        return this._currentHitPoints;
    }

    public int GetMaxHitPoints() {
        return this._maxHitPoints;
    }
    //endregion


    public Creature(int currentHitPoints, int maxHitPoints) {
        this._currentHitPoints = currentHitPoints;
        this._maxHitPoints = maxHitPoints;
    }

    public void TakeDamage(int damage) {
        this._currentHitPoints -= damage;

        if (this._currentHitPoints < 0)
            this._currentHitPoints = 0;
    }

    @Override
    public void MoveUp() {
        this._currentY--;
    }

    @Override
    public void MoveDown() {
        this._currentY++;
    }

    @Override
    public void MoveLeft() {
        this._currentX--;
    }

    @Override
    public void MoveRight() {
        this._currentX++;
    }
}

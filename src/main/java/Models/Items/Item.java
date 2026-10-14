package Models.Items;

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
}

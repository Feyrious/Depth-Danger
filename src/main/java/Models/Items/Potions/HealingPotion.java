package Models.Items.Potions;

public class HealingPotion extends BasePotion {
    private int _healingSize;
    private int _healingAmount;

    public void SetHealingAmount(int healingAmount) {
        this._healingAmount = healingAmount;
    }

    public int GetHealingAmount() {
        return this._healingAmount;
    }

    public void SetHealingSize(int healingSize) {
        this._healingSize = healingSize;
    }

    public int GetHealingSize() {
        return this._healingSize;
    }

    public HealingPotion(int _amount, String _name) {
        super(_amount, _name);
    }
}

package Models.Items.Potions;

import Services.DiceService.Dice;

public class HealingPotion extends BasePotion {

    private Dice _healingAmount;

    private int _staticHealingAmount;

    private void SetHealingAmount(Dice healingAmount) {
        this._healingAmount = healingAmount;
    }

    public int GetHealingAmount() {
        return _healingAmount.Roll() + _staticHealingAmount;
    }

    public HealingPotion(Dice healingAmount, int staticHealingAmount, String name) {
        super(name);
        SetHealingAmount(healingAmount);
        this._staticHealingAmount = staticHealingAmount;
    }
}

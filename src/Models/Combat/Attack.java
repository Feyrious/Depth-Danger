package Models.Combat;

import Models.Combat.Damage.Damage;

import java.util.ArrayList;

public class Attack {

    //region Class Properties
    private final ArrayList<Damage> _damageList;
    private int _attack;

    public void SetAttack(int attack) {
        this._attack = attack;
    }

    public int GetAttack() {
        return this._attack;
    }

    public void AddDamage(Damage damage) {
        this._damageList.add(damage);
    }

    public ArrayList<Damage> Get() {
        return this._damageList;
    }
    //endregion

    //region Class Constructors
    public Attack(int attack) {
        this._damageList = new ArrayList<>();
        this._attack = attack;
    }

    public Attack(ArrayList<Damage> damageList, int attack) {
        this._damageList = damageList;
        this._attack = attack;
    }
    //endregion



}

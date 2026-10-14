package World.Levels;

import Models.Actors.Monsters.BaseMonster;
import Models.Actors.Player.Character;
import Models.Items.Treasure;
import World.Tile;

import java.util.ArrayList;

public class LevelTwo extends BaseLevel {

    public LevelTwo() {
        this._levelLayout = this.SetLevelLayout();
        this._levelGrid = new Tile[GetLevelHeight()][GetLevelWidth()];
        this.InitMap();
        this.SetLevelExitLocation();
    }

    @Override
    String[] SetLevelLayout() {
        return new String[] {
                "██████████████████████████████████████████████████████████████",
                "█     █                       █                       █   ≡  █",
                "█     █           █           █           █           █      █",
                "█     █           █           █           █           █      █",
                "█     █           █           █           █           █      █",
                "█     █           █           █           █           █      █",
                "█     █           █           █           █           █      █",
                "█     █           █           █           █           █      █",
                "█     █           █           █           █           █      █",
                "█                 █                       █                  █",
                "██████████████████████████████████████████████████████████████"
        };
    }

    @Override
    public int GetLevelNumber() {
        return 2;
    }

    @Override
    public String GetLevelCode() {
        return "Darkness";
    }

    @Override
    public void SetPlayerStartPosition(Character player) {
        player.SetStartPosition(3,1);
    }

    @Override
    public ArrayList<BaseMonster> GetMonsterList() {
        return null;
    }

    @Override
    public ArrayList<Treasure> GetTreasureList() {
        return null;
    }

    @Override
    protected void SetLevelExitLocation() {
        this._exitX = 58;
        this._exitY = 1;
    }

    public ArrayList<BaseMonster> GetLevelMonsters() {
        return null;
    }
}

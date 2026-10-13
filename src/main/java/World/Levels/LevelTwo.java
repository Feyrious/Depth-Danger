package World.Levels;

import Models.Actors.Monsters.BaseMonster;
import Models.Actors.Player.Character;
import World.Tile;

import java.util.ArrayList;

public class LevelTwo extends BaseLevel {

    public LevelTwo() {
        this._levelLayout = this.SetLevelLayout();
        this._levelGrid = new Tile[getLevelHeight()][getLevelWidth()];
        this.InitMap();
    }

    @Override
    String[] SetLevelLayout() {
        return new String[] {
                "█████████████████████████████████████████",
                "█      ⌼ █                █           ≡ █",
                "█        █                █             █",
                "█        ⌸                █             █",
                "█        █                █             █",
                "█████⌸██████████⌸█████████████⌸██████████",
                "█          █          █                 █",
                "█          █          █                 █",
                "█          █          ⌸                 █",
                "█          █          █               ⌼ █",
                "█████████████████████████████████████████"
        };
    }

    @Override
    public int GetLevelNumber() {
        return 2;
    }

    @Override
    public String GetLevelCode() {
        return "potions!";
    }

    @Override
    public void SetPlayerStartPosition(Character player) {

    }

    @Override
    public ArrayList<BaseMonster> GetLevelMonsters() {
        return null;
    }
}

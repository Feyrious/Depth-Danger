package World.Levels;

import Models.Actors.Monsters.BaseMonster;
import Models.Actors.Player.Character;
import Models.Items.Treasure;
import World.Tile;

import java.util.ArrayList;

public class LevelThree extends BaseLevel {

    public LevelThree() {
        this._levelLayout = this.SetLevelLayout();
        this._levelGrid = new Tile[GetLevelHeight()][GetLevelWidth()];
        this.InitMap();
        this.SetLevelExitLocation();
    }

    @Override
    String[] SetLevelLayout() {
        return new String[] {
                "██████████████████████████████████████████████████████████████",
                "█      ⌼ █                █             █     █            ≡ █",
                "█        ⌸                █             █     ⌸              █",
                "█        ██████████████   █             █     ████████████████",
                "█        █                █             █     ⌸              █",
                "█████⌸██████████⌸█████████████⌸█████████████████████████⌸█████",
                "█          █          █                 █            █       █",
                "█          █          ███████████████   ⌸            █       █",
                "█          █          ⌸                 █████⌸████████       █",
                "█          █          █               ⌼ █                    █",
                "██████████████████████████████████████████████████████████████"
        };
    }

    @Override
    public int GetLevelNumber() {
        return 3;
    }

    @Override
    public String GetLevelCode() {
        return "potions!";
    }

    @Override
    public void SetPlayerStartPosition(Character player) {

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
        this._exitX = 0;
        this._exitY = 0;
    }

    public ArrayList<BaseMonster> GetLevelMonsters() {
        return null;
    }
}

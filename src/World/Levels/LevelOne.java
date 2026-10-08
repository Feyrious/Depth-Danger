package World.Levels;

import Models.Actors.Monsters.BaseMonster;
import Models.Actors.Monsters.Enums.MonsterMovementTypeEnum;
import Models.Actors.Monsters.Humanoids.Goblin;
import Models.Actors.Player.Character;
import World.Interfaces.ILevel;
import World.Tile;

import java.util.ArrayList;
import java.util.Arrays;

public class LevelOne extends BaseLevel {

    public LevelOne() {
        this._levelLayout = this.SetLevelLayout();
        this._levelGrid = new Tile[getLevelHeight()][getLevelWidth()];
        this.InitMap();
    }

    @Override
    protected String[] SetLevelLayout() {
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
    public void SetPlayerStartPosition(Character player) {
        player.SetStartPosition(3, 9);
    }

    @Override
    public ArrayList<BaseMonster> GetLevelMonsters() {
        var monsters = new ArrayList<BaseMonster>();

        var monster1 = new Goblin();
        monster1.SetStartPosition(2, 2);
        monster1.SetMovementPattern(MonsterMovementTypeEnum.Search);

        var monster2 = new Goblin();
        monster2.SetStartPosition(15, 8);
        monster2.SetMovementPattern(MonsterMovementTypeEnum.Random);

        var monster3 = new Goblin();
        monster3.SetStartPosition(25, 7);
        monster3.SetMovementPattern(MonsterMovementTypeEnum.Patrol);

        monsters.addAll(Arrays.asList(monster1, monster2, monster3));

        return monsters;
    }
    //endregio
}

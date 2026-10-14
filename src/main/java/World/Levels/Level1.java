package World.Levels;

import Models.Actors.Monsters.BaseMonster;
import Models.Actors.Monsters.Enums.MonsterMovementTypeEnum;
import Models.Actors.Monsters.Humanoids.Goblin;
import Models.Actors.Player.Character;
import Models.Items.Treasure;
import World.Tile;

import java.util.ArrayList;
import java.util.Arrays;

public class Level1 extends BaseLevel {

    public Level1() {
        this._levelLayout = this.SetLevelLayout();
        this._levelGrid = new Tile[GetLevelHeight()][GetLevelWidth()];
        this.InitMap();
        this.SetLevelExitLocation();
    }

    @Override
    protected String[] SetLevelLayout() {
        return new String[] {
                  // X-coordinates
                  //1   5    10   15   20   25   30   35   40   45   50   55   60
                  //↓   ↓    ↓    ↓    ↓    ↓    ↓    ↓    ↓    ↓    ↓    ↓    ↓
        /* Y0  */ "██████████████████████████████████████████████████████████████",
        /* Y1  */ "█  ⌼         █             █ ⌼                             ≡ █",
        /* Y2  */ "█            █             █                                 █",
        /* Y3  */ "█            ⌸             ⌸                                 █",
        /* Y4  */ "█  ⌼         █             █                            ⌼    █",
        /* Y5  */ "███████⌸███████████████████████████████████████████⌸██████████",
        /* Y6  */ "█            █             █  ⌼                              █",
        /* Y7  */ "█            █  ⌼          █                                 █",
        /* Y8  */ "█            █             █                                 █",
        /* Y9  */ "█            ⌸             ⌸                                 █",
        /* Y10 */ "██████████████████████████████████████████████████████████████"
        };
    }

    @Override
    public int GetLevelNumber() {
        return 1;
    }

    @Override
    protected void SetLevelExitLocation() {
        this._exitX = 59;
        this._exitY = 1;
    }

    @Override
    public String GetLevelCode() {
        return "Chambers";
    }

    @Override
    public void SetPlayerStartPosition(Character player) {
        player.SetStartPosition(3, 9);
    }

    @Override
    public ArrayList<BaseMonster> GetMonsterList() {
        var monster1 = new Goblin();
        monster1.SetStartPosition(2, 2);
        monster1.SetMovementPattern(MonsterMovementTypeEnum.Search);

        var monster2 = new Goblin();
        monster2.SetStartPosition(15, 8);
        monster2.SetMovementPattern(MonsterMovementTypeEnum.Random);

        var monster3 = new Goblin();
        monster3.SetStartPosition(25, 7);
        monster3.SetMovementPattern(MonsterMovementTypeEnum.Patrol);

        var monsters = new ArrayList<BaseMonster>();
        monsters.addAll(Arrays.asList(monster1, monster2, monster3));

        return monsters;
    }

    @Override
    public ArrayList<Treasure> GetTreasureList() {
        var treasure1 = new Treasure(10, null);
        treasure1.SetStartPosition(3, 1);

        var treasure2 = new Treasure(15, null);
        treasure2.SetStartPosition(3, 4);

        var treasure3 = new Treasure(20, null);
        treasure3.SetStartPosition(16, 7);

        var treasure4 = new Treasure(10, null);
        treasure4.SetStartPosition(29, 1);

        var treasure5 = new Treasure(30, null);
        treasure5.SetStartPosition(30, 6);

        var treasure6 = new Treasure(5, null);
        treasure6.SetStartPosition(56, 4);

        var treasure = new ArrayList<Treasure>();
        treasure.addAll(Arrays.asList(treasure1, treasure2, treasure3, treasure4, treasure5, treasure6));

        return treasure;
    }
    //endregion
}

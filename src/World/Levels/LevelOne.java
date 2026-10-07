package World.Levels;

import World.Interfaces.ILevel;
import World.Tile;

public class LevelOne implements ILevel {

    //region Fields
    private static final String[] VISUAL_LEVEL_LAYOUT = {
            "███████████",
            "█  ⌼█    ≡█",
            "█   █     █",
            "██⌸████⌸███",
            "█   ⌸     █",
            "█   █    ⌼█",
            "███████████"
    };

    private Tile[][] _levelGrid;

    @Override
    public Tile[][] getLevelTiles() {
        return this._levelGrid;
    }

    @Override
    public int getLevelHeight() {
        return 7-1;
    }

    @Override
    public int getLevelWidth() {
        return 11-1;
    }
    //endregion

    public LevelOne() {
        this._levelGrid = new Tile[getLevelHeight()][getLevelWidth()];
        InitMap();
    }

    private void InitMap() {
        for (int y = 0; y < getLevelHeight(); y++) {
            String row = VISUAL_LEVEL_LAYOUT[y];
            for (int x = 0; x < getLevelWidth(); x++) {
                char c = row.charAt(x);
                _levelGrid[y][x] = new Tile(c);
            }
        }
    }
}

package GameEngine.UIRenderer;

import Models.Actors.Monsters.BaseMonster;
import Models.Actors.Player.Character;
import World.Enums.TileTypeEnum;
import World.GameBoard;
import World.Tile;

import java.util.ArrayList;

public class NavigationMap {
    public static void RenderMap(GameBoard level, Character character, ArrayList<BaseMonster> monsters) {
        for (int y = 0; y < level.GetHeight(); y++) {
            for (int x = 0; x < level.GetWidth(); x++) {
                if (character != null && character.GetCurrentX() == x && character.GetCurrentY() == y) {
                    System.out.print(new Tile(TileTypeEnum.Character).GetTileChar());
                } else {
                    int finalX = x;
                    int finalY = y;
                    if (monsters != null && monsters.stream().anyMatch(monster -> monster.GetCurrentX() == finalX && monster.GetCurrentY() == finalY)) {
                        System.out.print(new Tile(TileTypeEnum.Goblin).GetTileChar());
                    }
                    else {
                        System.out.print(level.GetTile(x, y).GetTileChar());
                    }
                }
            }
            System.out.println();
        }
    }
}

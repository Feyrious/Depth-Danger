package GameEngine.UIRenderer;

import World.GameBoard;

public class NavigationMap {
    public static void RenderMap(GameBoard level) {
        for (int y = 0; y < level.GetHeight(); y++) {
            for (int x = 0; x < level.GetWidth(); x++) {
                System.out.print(level.GetTile(x, y).GetTileChar());
            }
            System.out.println();
        }
    }
}

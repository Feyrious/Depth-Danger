package GameEngine.State;

import Services.TerminalService.TerminalHelper;
import Services.UIServices.Renderer.Logger;
import Services.UIServices.Renderer.MainMenu;
import World.Levels.LevelSelector;

public class GameOptions {
    public static void StartNewGame(int levelNumber) {
        boolean isPlaying = true;

        do {
            var selectedLevel = LevelSelector.GetLevelByNumber(levelNumber);
            var gameState = new GameState(selectedLevel);

            isPlaying = gameState.RunLevel();
            levelNumber++;

        } while (isPlaying);
    }

    public static void EnterLevelCode() {
        boolean isEnteringCode = true;

        do {
            MainMenu.RenderGameTitle();
            MainMenu.RenderEnterLevelCode();
            Logger.RenderLogs();

            var value = TerminalHelper.readLine();
            var levelNumber = LevelSelector.GetLevelNumberByCode(value);

            if(levelNumber > 0) {
                StartNewGame(levelNumber);
                isEnteringCode = false;
            } else {
                MainMenu.RenderGameTitle();
                MainMenu.RenderTryAgainLevelCode();
                Logger.RenderLogs();

                var answer = TerminalHelper.readKey();

                switch (answer) {
                    case 'n':
                        isEnteringCode = false;
                        break;
                    case 'y':
                    default:
                        continue;
                }
            }

        } while (isEnteringCode);
    }
}

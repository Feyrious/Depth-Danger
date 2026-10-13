import GameEngine.State.GameState;
import Services.LoggingService.DebugService;
import Services.TerminalService.TerminalHelper;
import Services.UIServices.Renderer.MainMenu;
import World.Interfaces.ILevel;
import World.Levels.LevelOne;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    // Set desired dimensions (in characters)
    static int _cols = 70;
    static int _rows = 22;

    public static void main(String[] args) {
        DebugService.CheckIfInDebugMode(args);
        resizeConsole(_cols, _rows);

        MainMenu.RenderGameTitle();
        MainMenu.RenderMenuOptions();

        char option;

        do {
            option = TerminalHelper.readKey();

            switch (option) {
                case 's':
                    StartNewGame();
                    break;
                case 'l':
                    break;
                case 'o':
                    break;
                case 'q':
                    break;
            }
        } while (option != 'q');

    }

    private static void StartNewGame() {
        ILevel level = new LevelOne();
        var gameState = new GameState(level);
        gameState.RunLevel();
    }

    public static void resizeConsole(int cols, int rows) {
        // Step 1: Attempt the universal ANSI Escape Sequence
        // '\e[8;H;Wt' is the standard XTerm sequence for resizing text areas
        System.out.print(String.format("\033[8;%d;%dt", rows, cols));
        System.out.flush();

        // Step 2: Use OS-specific fallback commands to force compliance
        String os = System.getProperty("os.name").toLowerCase();
        try {
            if (os.contains("win")) {
                // Windows legacy Command Prompt (cmd.exe) fallback
                new ProcessBuilder("cmd", "/c", String.format("mode con: cols=%d lines=%d", cols, rows))
                        .inheritIO()
                        .start()
                        .waitFor();
            } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
                // Linux / macOS fallback using the 'stty' command
                new ProcessBuilder("sh", "-c", String.format("stty cols %d rows %d < /dev/tty", cols, rows))
                        .inheritIO()
                        .start()
                        .waitFor();
            }
        } catch (IOException | InterruptedException e) {
            // Absorb or log exceptions if the host environment blocks window manipulation
            System.err.println("Could not force OS-level console resize: " + e.getMessage());
        }
    }
}

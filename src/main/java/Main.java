import GameEngine.State.GameOptions;
import Services.LoggingService.DebugService;
import Services.TerminalService.TerminalHelper;
import Services.UIServices.Renderer.Logger;
import Services.UIServices.Renderer.MainMenu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DebugService.CheckIfInDebugMode(args);
        resizeConsole();

        char option;

        do {
            MainMenu.RenderGameTitle();
            MainMenu.RenderMenuOptions();
            Logger.RenderLogs();

            option = TerminalHelper.readKey();

            switch (option) {
                case 's':
                    GameOptions.StartNewGame(1);
                    break;
                case 'l':
                    GameOptions.EnterLevelCode();
                    break;
                case 'o':
                    break;
                case 'q':
                    break;
            }
        } while (option != 'q');

    }

    public static void resizeConsole() {
        int cols = 70;
        int rows = 24;

        if (DebugService.IsInDebugMode())
            rows += 7;

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

package GameEngine.UIRenderer;

import Services.LoggingService.ConsoleLogger;

public class GameMessages {
    public static void RenderMessages() {

        if (ConsoleLogger._gameMessageBuffer.size() == 0){
            System.out.println("╭───────────────────────────────────────╮");
            System.out.println("│                                       │");
            System.out.println("╰───────────────────────────────────────╯");
        } else {
            System.out.println("╭───────────────────────────────────────╮");
            for (String message : ConsoleLogger._gameMessageBuffer){
                int paddingSize = Math.max(0, 37 - message.length());
                System.out.println("│ " + message + " ".repeat(paddingSize) + " │");
            }
            System.out.println("╰───────────────────────────────────────╯");

            ConsoleLogger._gameMessageBuffer.clear();
        }

    }
}
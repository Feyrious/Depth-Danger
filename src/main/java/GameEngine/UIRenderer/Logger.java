package GameEngine.UIRenderer;

import Services.LoggingService.ConsoleLogger;

public class Logger {
    public static void RenderLogs() {
        if (ConsoleLogger._messageBuffer.size() == 0)
            return;

        for (String message : ConsoleLogger._messageBuffer) {
            System.out.println(message);
        }

        ConsoleLogger._messageBuffer.clear();
    }
}

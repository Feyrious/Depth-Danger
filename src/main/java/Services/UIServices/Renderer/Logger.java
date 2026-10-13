package Services.UIServices.Renderer;

import Services.LoggingService.ConsoleLogger;
import Services.LoggingService.DebugService;

public class Logger {
    public static void RenderLogs() {
        if (!DebugService.IsInDebugMode())
            return;

        if (ConsoleLogger._messageBuffer.size() == 0)
            return;

        for (String message : ConsoleLogger._messageBuffer) {
            System.out.println(message);
        }

        ConsoleLogger._messageBuffer.clear();
    }
}

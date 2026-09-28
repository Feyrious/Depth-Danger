package LoggingService;

import static UIServices.ConsoleFormater.*;

public class ConsoleLogger implements ILogger{
    @Override
    public void Logg(LogLevel level, String message) {
        SetColorCode(level);
        PrintLog(level, message);
        ResetColorCode();
    }

    private void SetColorCode(LogLevel level)  {
        switch (level) {
            case INFO:
                IO.print(COLOR_CYAN);
                break;
            case DEBUG:
                IO.print(COLOR_GREEN);
                break;
            case WARNING:
                IO.print(COLOR_YELLOW);
                break;
            case ERROR:
            case CRITICAL:
                IO.print(COLOR_RED);
                break;
        }
    }

    private void PrintLog(LogLevel level, String message) {
        IO.println("-----------------");
        IO.println(level.name() + ": " + message);
        IO.println("-----------------");
    }

    private void ResetColorCode() {
        IO.println(COLOR_RESET);
    }
}

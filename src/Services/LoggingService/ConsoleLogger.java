package Services.LoggingService;

import Services.LoggingService.Enums.ErrorLevelEnum;
import Services.LoggingService.Enums.InfoLevelEnum;
import static Services.UIServices.ConsoleFormater.*;

import java.util.Arrays;

import static Services.UIServices.ConsoleFormater.*;

public class ConsoleLogger implements ILogger{
    @Override
    public void LoggInfo(InfoLevelEnum level, String message) {
        SetInfoColorCode(level);
        PrintLog(level, message);
        ResetColorCode();
    }

    @Override
    public void LoggError(ErrorLevelEnum level, String message) {
        SetErrorColorCode(level);
        PrintError(level, message);
        ResetColorCode();
    }

    @Override
    public void LoggCritical(String customMessage, Exception ex) {
        SetCriticalColorCode();
        PrintException(customMessage, ex);
        ResetColorCode();
    }

    private void SetInfoColorCode(InfoLevelEnum level)  {
        switch (level) {
            case INFO:
                IO.print(COLOR_CYAN);
                break;
            case DEBUG:
                IO.print(COLOR_GREEN);
                break;
        }
    }

    private void SetErrorColorCode(ErrorLevelEnum level)  {
        switch (level) {
            case WARNING:
                IO.print(COLOR_YELLOW);
                break;
            case ERROR:
        }
    }

    private void SetCriticalColorCode()  {
                IO.print(COLOR_RED);
    }

    private void PrintLog(InfoLevelEnum level, String message) {
        IO.println("-----------------");
        IO.println(level.name() + ": " + message);
        IO.println("-----------------");
    }

    private void PrintError(ErrorLevelEnum level, String message) {
        IO.println("-----------------");
        IO.println(level.name() + ": " + message);
        IO.println("-----------------");
    }

    private void PrintException(String customMessage, Exception ex) {
        IO.println("-----------------");
        IO.println("EXCEPTION: " + customMessage);
        if (ex.getMessage() != null) {
            IO.println(ex.getMessage());
        }
        for (StackTraceElement line : ex.getStackTrace()) {
            IO.println(line.toString());
        }
        IO.println("-----------------");
    }

    private void ResetColorCode() {
        IO.println(COLOR_RESET);
    }
}

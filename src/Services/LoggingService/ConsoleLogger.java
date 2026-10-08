package Services.LoggingService;

import Services.LoggingService.Enums.ErrorLevelEnum;
import Services.LoggingService.Enums.InfoLevelEnum;
import Services.LoggingService.Interfaces.ILogger;

import static Services.UIServices.ConsoleFormater.*;

public class ConsoleLogger implements ILogger {
    @Override
    public void LoggInfo(InfoLevelEnum level, String message) {
        boolean isDebug = java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().contains("jdwp");

        if (level == InfoLevelEnum.DEBUG) {
            if (isDebug) {
                SetInfoColorCode(level);
                PrintLog(level, message);
                ResetColorCode();
            }
        } else {
            SetInfoColorCode(level);
            PrintLog(level, message);
            ResetColorCode();
        }

    }

    @Override
    public void LoggInfo(InfoLevelEnum infoLevelEnum, int message) {
        LoggInfo(infoLevelEnum, String.valueOf(message));
    }

    @Override
    public void LoggError(ErrorLevelEnum level, String message) {
        SetErrorColorCode(level);
        PrintError(level, message);
        ResetColorCode();
    }

    @Override
    public void LoggError(ErrorLevelEnum errorLevelEnum, int message) {
        LoggError(errorLevelEnum, String.valueOf(message));
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
                System.out.print(COLOR_CYAN);
                break;
            case DEBUG:
                System.out.print(COLOR_GREEN);
                break;
        }
    }

    private void SetErrorColorCode(ErrorLevelEnum level)  {
        switch (level) {
            case WARNING:
                System.out.print(COLOR_YELLOW);
                break;
            case ERROR:
                break;
        }
    }

    private void SetCriticalColorCode()  {
        System.out.print(COLOR_RED);
    }

    private void PrintLog(InfoLevelEnum level, String message) {
        System.out.println("-----------------");
        System.out.println(level.name() + ": " + message);
        System.out.println("-----------------");
    }

    private void PrintError(ErrorLevelEnum level, String message) {
        System.out.println("-----------------");
        System.out.println(level.name() + ": " + message);
        System.out.println("-----------------");
    }

    private void PrintException(String customMessage, Exception ex) {
        System.out.println("-----------------");
        System.out.println("EXCEPTION: " + customMessage);
        if (ex.getMessage() != null) {
            System.out.println(ex.getMessage());
        }
        for (StackTraceElement line : ex.getStackTrace()) {
            System.out.println(line.toString());
        }
        System.out.println("-----------------");
    }

    private void ResetColorCode() {
        System.out.println(COLOR_RESET);
    }
}

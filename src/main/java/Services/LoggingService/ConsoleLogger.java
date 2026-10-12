package Services.LoggingService;

import Services.LoggingService.Enums.ErrorLevelEnum;
import Services.LoggingService.Enums.InfoLevelEnum;

import java.util.ArrayList;

import static Services.UIServices.ConsoleFormater.*;

public class ConsoleLogger {

    public static boolean _inDebugMode = java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().contains("jdwp");

    public static ArrayList<String> _messageBuffer = new ArrayList<>();

    public static ArrayList<String> _gameMessageBuffer = new ArrayList<>();

    public static void LogGameMessage(String message) {
        _gameMessageBuffer.add(message);
    }

    public static void LogInfo(InfoLevelEnum level, String message) {
        if (level == InfoLevelEnum.DEBUG) {
            if (_inDebugMode) {
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

    public static void LogInfo(InfoLevelEnum infoLevelEnum, int message) {
        LogInfo(infoLevelEnum, String.valueOf(message));
    }

    public static void LogError(ErrorLevelEnum level, String message) {
        SetErrorColorCode(level);
        PrintError(level, message);
        ResetColorCode();
    }

    public static void LogError(ErrorLevelEnum errorLevelEnum, int message) {
        LogError(errorLevelEnum, String.valueOf(message));
    }

    public static void LogCritical(String customMessage, Exception ex) {
        SetCriticalColorCode();
        PrintException(customMessage, ex);
        ResetColorCode();
    }

    private static void SetInfoColorCode(InfoLevelEnum level)  {
        switch (level) {
            case INFO:
                _messageBuffer.add(COLOR_CYAN);
                break;
            case DEBUG:
                _messageBuffer.add(COLOR_GREEN);
                break;
        }
    }

    private static void SetErrorColorCode(ErrorLevelEnum level)  {
        switch (level) {
            case WARNING:
                _messageBuffer.add(COLOR_YELLOW);
                break;
            case ERROR:
                break;
        }
    }

    private static void SetCriticalColorCode()  {
        _messageBuffer.add(COLOR_RED);
    }

    private static void PrintLog(InfoLevelEnum level, String message) {
        _messageBuffer.add("----------------------------------");
        _messageBuffer.add(level.name() + ": " + message);
        _messageBuffer.add("----------------------------------");
    }

    private static void PrintError(ErrorLevelEnum level, String message) {
        _messageBuffer.add("----------------------------------");
        _messageBuffer.add(level.name() + ": " + message);
        _messageBuffer.add("----------------------------------");
    }

    private static void PrintException(String customMessage, Exception ex) {
        _messageBuffer.add("----------------------------------");
        _messageBuffer.add("EXCEPTION: " + customMessage);
        if (ex.getMessage() != null) {
            _messageBuffer.add(ex.getMessage());
        }
        for (StackTraceElement line : ex.getStackTrace()) {
            _messageBuffer.add(line.toString());
        }
        _messageBuffer.add("----------------------------------");
    }

    private static void ResetColorCode() {
        _messageBuffer.add(COLOR_RESET);
    }
}

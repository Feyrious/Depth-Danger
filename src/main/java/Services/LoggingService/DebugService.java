package Services.LoggingService;

import Services.LoggingService.Enums.InfoLevelEnum;

import java.util.Arrays;

public class DebugService {
    private static boolean _inDebugMode = false;

    public static boolean IsInDebugMode() {
        return _inDebugMode;
    }

    public static void CheckIfInDebugMode(String[] args) {
        boolean isDebuggerAttached = java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().contains("jdwp");
        boolean hasDebugFlag = Arrays.stream(args).anyMatch(arg -> arg.equals("--debug"));

        if (isDebuggerAttached || hasDebugFlag) {
            _inDebugMode = true;
            ConsoleLogger.LogInfo(InfoLevelEnum.DEBUG, "Debug mode enabled");
        }
    }
}

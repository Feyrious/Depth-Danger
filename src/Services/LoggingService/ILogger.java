package Services.LoggingService;


import Services.LoggingService.Enums.ErrorLevelEnum;
import Services.LoggingService.Enums.InfoLevelEnum;

public interface ILogger {

    /**
     * Logs a simple message to the Console
     * @param level The level of the information being logged
     * @param message The message itself being logged
     */
    public void LoggInfo(InfoLevelEnum level, String message);

    /**
     * Logs a simple message to the Console
     * @param level The level of the error being logged
     * @param message The error message itself being logged
     */
    public void LoggError(ErrorLevelEnum level, String message);

    /**
     * Logs a simple message to the Console
     * @param customMessage Any custom message added to the exception being thrown
     * @param exception The captured exception to be logged
     */
    public void LoggCritical(String customMessage, Exception exception);
}

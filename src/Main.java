import LoggingService.ConsoleLogger;
import LoggingService.LogLevel;

void main() {
    var logger = new ConsoleLogger();

    logger.Logg(LogLevel.INFO, "Info Message");
    logger.Logg(LogLevel.DEBUG, "Debug Message");
    logger.Logg(LogLevel.WARNING, "Warning Message");
    logger.Logg(LogLevel.ERROR, "Error Message");
    logger.Logg(LogLevel.CRITICAL, "Critical Message");
}

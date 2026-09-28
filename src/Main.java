import Services.LoggingService.ConsoleLogger;
import Services.LoggingService.Enums.ErrorLevelEnum;
import Services.LoggingService.Enums.InfoLevelEnum;

void main() {
    var logger = new ConsoleLogger();
    var scanner = new Scanner(System.in);

    logger.LoggInfo(InfoLevelEnum.INFO, "Info Message");
    logger.LoggInfo(InfoLevelEnum.DEBUG, "Debug Message");
    logger.LoggError(ErrorLevelEnum.WARNING, "Warning Message");
    logger.LoggError(ErrorLevelEnum.ERROR, "Error Message");

    try {
        var intValue = scanner.nextInt();
    } catch (InputMismatchException ex) {
        logger.LoggCritical("Incorrect input value", ex);
    }
}

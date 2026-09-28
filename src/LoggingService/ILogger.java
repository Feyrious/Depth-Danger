package LoggingService;


public interface ILogger {

    /**
     *
     * @param level
     * @param message
     */
    public void Logg(LogLevel level, String message);
}

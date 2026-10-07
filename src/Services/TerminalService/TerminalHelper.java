package Services.TerminalService;

import java.io.IOException;

public class TerminalHelper {
    public static char readKey() {
        String os = System.getProperty("os.name").toLowerCase();

        // --- LINUX / MACOS IMPLEMENTATION ---
        if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            try {
                // 1. Put the Linux terminal driver into "raw" mode instantly
                String[] cmdRaw = {"/bin/sh", "-c", "stty raw </dev/tty"};
                Runtime.getRuntime().exec(cmdRaw).waitFor();

                // 2. Read exactly 1 single byte from standard input stream
                int singleByte = System.in.read();

                // 3. IMMEDIATELY restore terminal to normal "cooked" mode
                String[] cmdCooked = {"/bin/sh", "-c", "stty cooked </dev/tty"};
                Runtime.getRuntime().exec(cmdCooked).waitFor();

                // Handle Ctrl+C intercept gracefully (ASCII byte 3)
                if (singleByte == 3) {
                    System.out.println("\nExiting via Ctrl+C...");
                    System.exit(0);
                }

                return (char) singleByte;

            } catch (IOException | InterruptedException e) {
                // Fallback to Scanner if running inside an IDE layout
                return fallbackScanner();
            }

            // --- WINDOWS IMPLEMENTATION ---
        } else if (os.contains("win")) {
            // Windows native consoles actually support immediate character reads via standard streams
            // when wrapped cleanly or via similar native hooks.
            try {
                int singleByte = System.in.read();
                return (char) singleByte;
            } catch (IOException e) {
                return fallbackScanner();
            }
        }

        return fallbackScanner();
    }

    private static char fallbackScanner() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        if (scanner.hasNext()) {
            String str = scanner.next();
            if (!str.isEmpty()) return str.charAt(0);
        }
        return ' ';
    }
}

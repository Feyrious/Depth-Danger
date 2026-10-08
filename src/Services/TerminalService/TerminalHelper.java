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

                // Handle ANSI escape sequences for arrow keys (ESC [ A/B/C/D or ESC O A/B/C/D)
                if (singleByte == 27) {
                    if (System.in.available() > 0) {
                        int code1 = System.in.read();
                        if (code1 == '[' || code1 == 'O') {
                            int code2 = System.in.read();

                            // Restore terminal before returning
                            String[] cmdCooked = {"/bin/sh", "-c", "stty cooked </dev/tty"};
                            Runtime.getRuntime().exec(cmdCooked).waitFor();

                            switch (code2) {
                                case 'A': return 'w'; // Up Arrow -> Up
                                case 'B': return 's'; // Down Arrow -> Down
                                case 'C': return 'd'; // Right Arrow -> Right
                                case 'D': return 'a'; // Left Arrow -> Left
                                default: return (char) code2;
                            }
                        }
                    }
                }

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
            try {
                int singleByte = System.in.read();
                // Handle Windows extended virtual keys (0x00 or 0xE0 prefix for arrow keys)
                if (singleByte == 0 || singleByte == 224) {
                    if (System.in.available() > 0) {
                        int code = System.in.read();
                        switch (code) {
                            case 72: return 'w'; // Up Arrow -> Up
                            case 80: return 's'; // Down Arrow -> Down
                            case 75: return 'a'; // Left Arrow -> Left
                            case 77: return 'd'; // Right Arrow -> Right
                            default: return (char) code;
                        }
                    }
                }
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

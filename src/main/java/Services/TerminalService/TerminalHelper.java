package Services.TerminalService;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;

import java.io.IOException;

public class TerminalHelper {
    private static Terminal terminal;
    private static NonBlockingReader reader;

    // This static block runs once when the game starts
    static {
        try {
            // Automatically builds a terminal using JNA and sets it to raw mode
            terminal = TerminalBuilder.builder().system(true).build();
            terminal.enterRawMode();
            reader = terminal.reader();
        } catch (IOException e) {
            System.err.println("Failed to initialize JLine terminal: " + e.getMessage());
        }
    }

    public static char readKey() {
        try {
            // Reads a single keystroke instantly without waiting for Enter
            int key = reader.read();

            // Handle arrow keys (ANSI escape sequences start with ESC / 27)
            if (key == 27) {
                int next = reader.read();
                if (next == '[' || next == 'O') {
                    int arrow = reader.read();
                    switch (arrow) {
                        case 'A': return 'w'; // Up Arrow
                        case 'B': return 's'; // Down Arrow
                        case 'C': return 'd'; // Right Arrow
                        case 'D': return 'a'; // Left Arrow
                    }
                }
            }

            // Handle Ctrl+C (ASCII 3)
            if (key == 3) {
                System.out.println("\nExiting...");
                System.exit(0);
            }

            return (char) key;
        } catch (IOException e) {
            return ' ';
        }
    }

    public static String readLine() {
        StringBuilder inputBuffer = new StringBuilder();
        try {
            while (true) {
                int key = reader.read();

                if (key == 3) { // Ctrl+C
                    System.out.println("\nExiting...");
                    System.exit(0);
                }

                // Enter Key (\r or \n)
                if (key == '\r' || key == '\n') {
                    System.out.println();
                    break;
                }

                // Backspace / Delete (ASCII 8 or 127)
                if (key == 127 || key == 8) {
                    if (inputBuffer.length() > 0) {
                        inputBuffer.deleteCharAt(inputBuffer.length() - 1);
                        System.out.print("\b \b"); // Erase last character on terminal
                        System.out.flush();
                    }
                }
                // Printable characters
                else if (key >= 32 && key <= 126) {
                    inputBuffer.append((char) key);
                    System.out.print((char) key);
                    System.out.flush();
                }
            }
        } catch (IOException e) {
            return "";
        }
        return inputBuffer.toString();
    }
}
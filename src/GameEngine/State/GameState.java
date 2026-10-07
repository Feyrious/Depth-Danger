package GameEngine.State;

import World.GameBoard;

public class GameState {
    private GameBoard _board;

    public void SetBoard(GameBoard board) {
        this._board = board;
    }

    public GameBoard GetBoard() {
        return this._board;
    }

    private static final int TICKS_PER_SECOND = 20;
    private static final long TIME_PER_TICK = 1000000000 / TICKS_PER_SECOND; // in nanoseconds

    // Game state
    private static boolean running = true;

    // Movement direction input buffer
    private static volatile char currentInput = ' ';

    public GameState(ILevel level) {
        this._board = new GameBoard(level);
        this.SetPlayer(new Character(20, 20));
    }

    public void RunLevel() {
       Scanner scanner = new Scanner(System.in);

        // Initial render to draw the starting screen
        render();

        // The input-driven game loop
        while (running) {
            char choice = TerminalHelper.readKey();

            // 1. Process player movement & choices
            boolean validTurn = processInput(choice);

            // 2. Only tick the game state forward if a valid action occurred
            if (validTurn && running) {
                tick();
            }

            // 3. Render the updated frame
            if (running) {
                render();
            }
        }

        scanner.close();
    }

    /**
     * The Ticking System: Everything else in the world updates here.
     * (e.g., enemies move, hunger drops, or events process right after your move).
     */
    private static void tick() {
        // Example: Enemy.tick();
        // Example: Environment.tick();

    }

    /**
     * Processes input. Returns true if a valid movement or turn action was taken.
     */
    private boolean processInput(char choice) {
        var character = this.GetPlayer();

        int currentX = character.GetCurrentX();
        int currentY = character.GetCurrentY();

        // Read keystrokes immediately (Supports WASD + Arrow Keys)
        if (choice == 'w') {
            if (_board.IsWalkable(currentX, currentY - 1))
                character.MoveUp();
        } else if (choice == 's') {
            if (_board.IsWalkable(currentX, currentY + 1))
                character.MoveDown();
        } else if (choice == 'a') {
            if (_board.IsWalkable(currentX - 1, currentY))
                character.MoveLeft();
        } else if (choice == 'd') {
            if (_board.IsWalkable(currentX + 1, currentY))
                character.MoveRight();
        } else if (choice == 'q') {
            running = false;
        } else {
            return false;
        }

        return true;
    }

    /**
     * The Render Pipeline: Prints your UI stats box, map, and legend.
     */
    private void render() {
        var character = this.GetPlayer();

        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();

        StatMenu.RenderStats(character);
        NavigationMap.RenderMap(_board, character, _board.GetMonsters());
        Legend.RenderLegend();

        System.out.flush();
    }
}

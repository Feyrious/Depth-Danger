package GameEngine.State;

import GameEngine.Movement.MovementService;
import GameEngine.UIRenderer.*;
import Models.Actors.Monsters.BaseMonster;
import Models.Actors.Player.Character;
import Services.LoggingService.ConsoleLogger;
import Services.TerminalService.TerminalHelper;
import World.GameBoard;
import World.Interfaces.ILevel;

import java.util.Scanner;

public class GameState {
    private GameBoard _board;
    private Character _player;

    public void SetPlayer(Character player) {
        this._player = player;
    }

    public Character GetPlayer() {
        return this._player;
    }

    public void SetBoard(GameBoard board) {
        this._board = board;
    }

    public GameBoard GetBoard() {
        return this._board;
    }

    // Game state
    private boolean running = true;

    public GameState(ILevel level) {
        this._board = new GameBoard(level);
        var playerCharacter = new Character(20, 20);
        level.SetPlayerStartPosition(playerCharacter);
        this.SetPlayer(playerCharacter);
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
    private void tick() {
        if (_board != null && _board.GetMonsters() != null) {
            for (BaseMonster monster : _board.GetMonsters()) {
                MovementService.MoveMonster(monster, _board);
            }
        }
    }

    /**
     * Processes input. Returns true if a valid movement or turn action was taken.
     */
    private boolean processInput(char choice) {
        if (choice == 'q' || choice == 'Q') {
            running = false;
            return false;
        }

        var character = this.GetPlayer();
        return MovementService.MovePlayer(character, _board, choice);
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
        GameMessages.RenderMessages();
        Legend.RenderLegend();
        Logger.RenderLogs();

        System.out.flush();
    }
}

package GameEngine.State;

import GameEngine.Movement.MovementService;
import Models.Actors.Monsters.BaseMonster;
import Models.Actors.Player.Character;
import Services.LoggingService.ConsoleLogger;
import Services.LoggingService.DebugService;
import Services.LoggingService.Enums.InfoLevelEnum;
import Services.LoggingService.Enums.LogLevel;
import Services.TerminalService.TerminalHelper;
import Services.UIServices.Renderer.*;
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
        ConsoleLogger.LogGameMessage("Level " + level.GetLevelNumber() + "!");
        this._board = new GameBoard(level);

        if (this.GetPlayer() == null)
            this.SetPlayer(new Character(level.GetLevelNumber()));

        level.SetPlayerStartPosition(this.GetPlayer());

        if (level.GetLevelNumber() > this.GetPlayer().GetCurrentLevel())
            this.GetPlayer().LevelUp();
    }

    public boolean RunLevel() {
        // Initial render to draw the starting screen
        render();

        // The input-driven game loop
        while (running) {
            char choice = TerminalHelper.readKey();

            // 1. Process player movement & choices
            boolean validTurn = processInput(choice);
            if (DebugService.IsInDebugMode())
                ConsoleLogger.LogInfo(InfoLevelEnum.DEBUG, "Player Current Position - X: " + String.format("%02d", this.GetPlayer().GetCurrentX()) + " Y: " + String.format("%02d", this.GetPlayer().GetCurrentY()));

            // 2. Only tick the game state forward if a valid action occurred
            if (validTurn && running) {
                if (this.GetBoard().GetLevel().IsOnExitLocation(this.GetPlayer())) {
                    ConsoleLogger.LogInfo(InfoLevelEnum.DEBUG, "You found the exit!");
                    return true;
                }

                tick();
            }

            // 3. Render the updated frame
            if (running) {
                render();
            }
        }

        return false;
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
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();

        StatMenu.RenderStats(this.GetPlayer());
        NavigationMap.RenderMap(_board, this.GetPlayer(), _board.GetMonsters());
        GameMessages.RenderMessages();
        Legend.RenderLegend();
        Logger.RenderLogs();

        System.out.flush();
    }
}

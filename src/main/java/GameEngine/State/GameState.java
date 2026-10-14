package GameEngine.State;

import GameEngine.Movement.MovementService;
import Models.Actors.Monsters.BaseMonster;
import Models.Actors.Player.Character;
import Models.Items.Item;
import Models.Items.Treasure;
import Services.LoggingService.ConsoleLogger;
import Services.LoggingService.DebugService;
import Services.LoggingService.Enums.InfoLevelEnum;
import Services.TerminalService.TerminalHelper;
import Services.UIServices.Renderer.*;
import World.GameBoard;
import World.Interfaces.ILevel;

public class GameState {
    private GameBoard _board;
    private static Character _character;

    public void SetPlayer(Character player) {
        this._character = player;
    }

    public Character GetCharacter() {
        return this._character;
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

        if (this.GetCharacter() == null)
            this.SetPlayer(new Character(level.GetLevelNumber()));

        level.SetPlayerStartPosition(this.GetCharacter());

        if (level.GetLevelNumber() > this.GetCharacter().GetCurrentLevel())
            this.GetCharacter().LevelUp();
    }

    public boolean RunLevel() {
        // Initial render to draw the starting screen
        render();

        // The input-driven game loop
        while (running) {
            if (!IsCharacterAlive())
                return false;

            char choice = TerminalHelper.readKey();

            // 1. Process player movement & choices
            boolean validTurn = processInput(choice);

            if (DebugService.IsInDebugMode())
                ConsoleLogger.LogInfo(InfoLevelEnum.DEBUG, "Player Current Position - X: " + String.format("%02d", this.GetCharacter().GetCurrentX()) + " Y: " + String.format("%02d", this.GetCharacter().GetCurrentY()));

            // 2. Only tick the game state forward if a valid action occurred
            if (validTurn && running) {
                if (this.GetBoard().GetLevel().IsOnExitLocation(this.GetCharacter())) {
                    ConsoleLogger.LogInfo(InfoLevelEnum.DEBUG, "You found the exit!");
                    return true;
                }

                checkForTreasure();

                monsterTick();
            }

            // 3. Render the updated frame
            if (running) {
                render();
            }

            // 4. Check if the game continues
            if (!IsCharacterAlive())
                return false;
        }

        return false;
    }

    private boolean IsCharacterAlive() {
        if (GetCharacter().GetCurrentHitPoints() == 0) {
            TerminalHelper.readKey();
            return false;
        } else {
            return true;
        }
    }

    private void checkForTreasure() {
        if (_board != null && _board.GetTreasureList() != null) {
            for (Treasure treasure : _board.GetTreasureList()) {
                if (this.GetCharacter().GetCurrentX() == treasure.GetCurrentX() && this.GetCharacter().GetCurrentY() == treasure.GetCurrentY())
                    this.GetCharacter().Collect(treasure);
            }
        }
    }

    /**
     * The Ticking System: Everything else in the world updates here.
     * (e.g., enemies move, hunger drops, or events process right after your move).
     */
    private void monsterTick() {
        // Move monsters
        if (_board != null && _board.GetMonsters() != null) {
            for (BaseMonster monster : _board.GetMonsters()) {
                MovementService.MoveMonster(monster, _board);

                // Attack Player
                if (monster.GetCurrentX() == GetCharacter().GetCurrentX() && monster.GetCurrentY() == GetCharacter().GetCurrentY()){
                    monster.Attack(GetCharacter());
                    if (GetCharacter().GetCurrentHitPoints() == 0)
                        ConsoleLogger.LogGameMessage("Game Over!");
                }
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

        var character = this.GetCharacter();
        return MovementService.MovePlayer(character, _board, choice);
    }

    /**
     * The Render Pipeline: Prints your UI stats box, map, and legend.
     */
    private void render() {
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();

        StatMenu.RenderStats(this.GetCharacter());
        NavigationMap.RenderMap(_board, this.GetCharacter(), _board.GetMonsters());
        GameMessages.RenderMessages();
        Legend.RenderLegend();
        Logger.RenderLogs();

        System.out.flush();
    }
}

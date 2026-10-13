package GameEngine.Movement;

import GameEngine.Movement.Interfaces.IMonsterMovementStrategy;
import GameEngine.Movement.Patterns.PatrolMovementPattern;
import GameEngine.Movement.Patterns.RandomMovementPattern;
import GameEngine.Movement.Patterns.SearchMovementPattern;
import Models.Actors.Interfaces.IMovable;
import Models.Actors.Monsters.BaseMonster;
import Models.Actors.Monsters.Enums.MonsterMovementTypeEnum;
import Services.LoggingService.ConsoleLogger;
import Services.LoggingService.Enums.InfoLevelEnum;
import World.GameBoard;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class MovementService {
    private static final Map<MonsterMovementTypeEnum, IMonsterMovementStrategy> strategies = new EnumMap<>(MonsterMovementTypeEnum.class);
    private static final IMonsterMovementStrategy defaultStrategy = new RandomMovementPattern();

    static {
        strategies.put(MonsterMovementTypeEnum.Random, new RandomMovementPattern());
        strategies.put(MonsterMovementTypeEnum.Patrol, new PatrolMovementPattern());
        strategies.put(MonsterMovementTypeEnum.Search, new SearchMovementPattern());
    }

    /**
     * Handles movement for the player based on directional user input:
     * - WASD ('w', 'a', 's', 'd' / 'W', 'A', 'S', 'D')
     * - Arrow keys ('↑', '↓', '←', '→')
     *
     * @param movable The player entity implementing IMovable.
     * @param board   The current game board.
     * @param input   The user's key input.
     * @return True if a valid movement direction was input, false otherwise.
     */
    public static boolean MovePlayer(IMovable movable, GameBoard board, char input) {
        if (movable == null || board == null) {
            return false;
        }

        int currentX = movable.GetCurrentX();
        int currentY = movable.GetCurrentY();
        char choice = Character.toLowerCase(input);

        switch (choice) {
            case 'w':
            case '↑':
                if (board.IsWalkable(currentX, currentY - 1)) {
                    movable.MoveUp();
                    ConsoleLogger.LogGameMessage("You moved up.");
                } else {
                    ConsoleLogger.LogGameMessage("You can't move there.");
                }
                return true;
            case 's':
            case '↓':
                if (board.IsWalkable(currentX, currentY + 1)) {
                    movable.MoveDown();
                    ConsoleLogger.LogGameMessage("You moved down.");
                } else {
                    ConsoleLogger.LogGameMessage("You can't move there.");
                }
                return true;
            case 'a':
            case '←':
                if (board.IsWalkable(currentX - 1, currentY)) {
                    movable.MoveLeft();
                    ConsoleLogger.LogGameMessage("You moved left.");
                } else {
                    ConsoleLogger.LogGameMessage("You can't move there.");
                }
                return true;
            case 'd':
            case '→':
                if (board.IsWalkable(currentX + 1, currentY)) {
                    movable.MoveRight();
                    ConsoleLogger.LogGameMessage("You moved right.");
                } else {
                    ConsoleLogger.LogGameMessage("You can't move there.");
                }
                return true;
            default:
                return false;
        }
    }

    /**
     * Handles monster movement by delegating to the strategy matched with the monster's configured pattern.
     *
     * @param movable The monster entity implementing IMovable.
     * @param board   The current game board.
     */
    public static void MoveMonster(IMovable movable, GameBoard board) {
        if (movable == null || board == null) {
            return;
        }

        if (movable instanceof BaseMonster monster) {
            MonsterMovementTypeEnum pattern = monster.GetMovementPattern();
            IMonsterMovementStrategy strategy = (pattern != null) ? strategies.getOrDefault(pattern, defaultStrategy) : defaultStrategy;
            strategy.Move(monster, board);
        }
    }

    /**
     * Moves all monsters in the list using their configured movement strategies.
     *
     * @param monsters The list of monsters.
     * @param board    The current game board.
     */
    public static void MoveMonsters(List<? extends IMovable> monsters, GameBoard board) {
        if (monsters == null || board == null) {
            return;
        }

        for (IMovable monster : monsters) {
            MoveMonster(monster, board);
        }
    }

    /**
     * Retrieves the movement strategy associated with a pattern.
     *
     * @param pattern The monster movement pattern.
     * @return The corresponding IMonsterMovementStrategy.
     */
    public static IMonsterMovementStrategy GetStrategy(MonsterMovementTypeEnum pattern) {
        return (pattern != null) ? strategies.getOrDefault(pattern, defaultStrategy) : defaultStrategy;
    }
}

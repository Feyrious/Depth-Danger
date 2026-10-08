package GameEngine.Movement;

import GameEngine.Movement.Interfaces.IMonsterMovementStrategy;
import GameEngine.Movement.Patterns.PatrolMovementPattern;
import GameEngine.Movement.Patterns.RandomMovementPattern;
import GameEngine.Movement.Patterns.SearchMovementPattern;
import Models.Actors.Entity;
import Models.Actors.Interfaces.IMovable;
import Models.Actors.Monsters.BaseMonster;
import Models.Actors.Monsters.Enums.MonsterMovementTypeEnum;
import Models.Actors.Monsters.HumanoidMonster;
import Models.Actors.Monsters.UndeadMonster;
import Models.Actors.Player.Character;
import World.GameBoard;
import World.Levels.LevelOne;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MovementServiceTest {

    @Test
    @DisplayName("Entity implements IMovable interface")
    void Entity_Implements_IMovable() {
        Entity entity = new Entity(10, 10);
        assertTrue(entity instanceof IMovable);
    }

    @Test
    @DisplayName("MovementDirection initializes and updates correctly")
    void MovementDirection_State_WorksCorrectly() {
        MovementDirection dir = new MovementDirection();
        assertEquals(1, dir.GetHeadingDirection());
        assertEquals(1, dir.GetHorizontalDirection());
        assertEquals(1, dir.GetVerticalDirection());

        dir.SetHeadingDirection(3);
        dir.SetHorizontalDirection(-1);
        dir.SetVerticalDirection(-1);

        assertEquals(3, dir.GetHeadingDirection());
        assertEquals(-1, dir.GetHorizontalDirection());
        assertEquals(-1, dir.GetVerticalDirection());
    }

    @Test
    @DisplayName("MovementService retrieves correct strategy implementations")
    void MovementService_ReturnsCorrectStrategies() {
        assertTrue(MovementService.GetStrategy(MonsterMovementTypeEnum.Random) instanceof RandomMovementPattern);
        assertTrue(MovementService.GetStrategy(MonsterMovementTypeEnum.Patrol) instanceof PatrolMovementPattern);
        assertTrue(MovementService.GetStrategy(MonsterMovementTypeEnum.Search) instanceof SearchMovementPattern);
        assertTrue(MovementService.GetStrategy(null) instanceof RandomMovementPattern);
    }

    @Test
    @DisplayName("BaseMonster default movement pattern is Random")
    void BaseMonster_DefaultPattern_IsRandom() {
        BaseMonster monster = new BaseMonster(10, 10);
        assertEquals(MonsterMovementTypeEnum.Random, monster.GetMovementPattern());
        assertNotNull(monster.GetMovementDirection());
    }

    @Test
    @DisplayName("HumanoidMonster default movement pattern is Patrol")
    void HumanoidMonster_DefaultPattern_IsPatrol() {
        HumanoidMonster monster = new HumanoidMonster(10, 10);
        assertEquals(MonsterMovementTypeEnum.Patrol, monster.GetMovementPattern());
        assertNotNull(monster.GetMovementDirection());
    }

    @Test
    @DisplayName("UndeadMonster default movement pattern is Search")
    void UndeadMonster_DefaultPattern_IsSearch() {
        UndeadMonster monster = new UndeadMonster(10, 10);
        assertEquals(MonsterMovementTypeEnum.Search, monster.GetMovementPattern());
        assertNotNull(monster.GetMovementDirection());
    }

    @Test
    @DisplayName("BaseMonster movement pattern can be overridden")
    void BaseMonster_CanOverrideMovementPattern() {
        BaseMonster monster = new BaseMonster(10, 10);
        monster.SetMovementPattern(MonsterMovementTypeEnum.Search);
        assertEquals(MonsterMovementTypeEnum.Search, monster.GetMovementPattern());

        monster.SetMovementPattern(MonsterMovementTypeEnum.Patrol);
        assertEquals(MonsterMovementTypeEnum.Patrol, monster.GetMovementPattern());
    }

    @Test
    @DisplayName("MovePlayer should move player in all WASD directions (lowercase and uppercase)")
    void MovePlayer_WASD_MovesPlayerCorrectly() {
        LevelOne level = new LevelOne();
        GameBoard board = new GameBoard(level);
        Character character = new Character(20, 20); // starts at (2, 2)

        // Right with 'd'
        assertTrue(MovementService.MovePlayer(character, board, 'd'));
        assertEquals(3, character.GetCurrentX());
        assertEquals(2, character.GetCurrentY());

        // Down with 'S' (uppercase)
        assertTrue(MovementService.MovePlayer(character, board, 'S'));
        assertEquals(3, character.GetCurrentX());
        assertEquals(3, character.GetCurrentY());

        // Left with 'a'
        assertTrue(MovementService.MovePlayer(character, board, 'a'));
        assertEquals(2, character.GetCurrentX());
        assertEquals(3, character.GetCurrentY());

        // Up with 'W' (uppercase)
        assertTrue(MovementService.MovePlayer(character, board, 'W'));
        assertEquals(2, character.GetCurrentX());
        assertEquals(2, character.GetCurrentY());
    }

    @Test
    @DisplayName("MovePlayer should move player with arrow keys (↑, ↓, ←, →)")
    void MovePlayer_ArrowKeys_MovesPlayerCorrectly() {
        LevelOne level = new LevelOne();
        GameBoard board = new GameBoard(level);
        Character character = new Character(20, 20); // starts at (2, 2)

        // Right arrow '→'
        assertTrue(MovementService.MovePlayer(character, board, '→'));
        assertEquals(3, character.GetCurrentX());
        assertEquals(2, character.GetCurrentY());

        // Down arrow '↓'
        assertTrue(MovementService.MovePlayer(character, board, '↓'));
        assertEquals(3, character.GetCurrentX());
        assertEquals(3, character.GetCurrentY());

        // Left arrow '←'
        assertTrue(MovementService.MovePlayer(character, board, '←'));
        assertEquals(2, character.GetCurrentX());
        assertEquals(3, character.GetCurrentY());

        // Up arrow '↑'
        assertTrue(MovementService.MovePlayer(character, board, '↑'));
        assertEquals(2, character.GetCurrentX());
        assertEquals(2, character.GetCurrentY());
    }

    @Test
    @DisplayName("MovePlayer should not move player into a wall")
    void MovePlayer_IntoWall_DoesNotChangePosition() {
        LevelOne level = new LevelOne();
        GameBoard board = new GameBoard(level);
        Character character = new Character(20, 20); // starts at (2, 2)

        // Move to (1, 2)
        MovementService.MovePlayer(character, board, 'a');
        assertEquals(1, character.GetCurrentX());
        assertEquals(2, character.GetCurrentY());

        // Attempt to move into wall at x=0 with 'a' and '←'
        boolean resultA = MovementService.MovePlayer(character, board, 'a');
        assertTrue(resultA);
        assertEquals(1, character.GetCurrentX()); // unchanged because x=0 is a wall
        assertEquals(2, character.GetCurrentY());

        boolean resultArrow = MovementService.MovePlayer(character, board, '←');
        assertTrue(resultArrow);
        assertEquals(1, character.GetCurrentX());
        assertEquals(2, character.GetCurrentY());
    }

    @Test
    @DisplayName("MovePlayer with invalid input should return false")
    void MovePlayer_InvalidInput_ReturnsFalse() {
        LevelOne level = new LevelOne();
        GameBoard board = new GameBoard(level);
        Character character = new Character(20, 20);

        boolean result = MovementService.MovePlayer(character, board, 'x');

        assertFalse(result);
        assertEquals(2, character.GetCurrentX());
        assertEquals(2, character.GetCurrentY());
    }

    @Test
    @DisplayName("Pattern 1 - RandomMovementPattern: moves monster to an adjacent walkable tile")
    void RandomMovementPattern_MovesToWalkableTile() {
        LevelOne level = new LevelOne();
        GameBoard board = new GameBoard(level);
        BaseMonster monster = new BaseMonster(10, 10, MonsterMovementTypeEnum.Random);

        // Position monster at (2, 2)
        while (monster.GetCurrentX() < 2) monster.MoveRight();
        while (monster.GetCurrentY() < 2) monster.MoveDown();

        IMonsterMovementStrategy strategy = new RandomMovementPattern();
        strategy.Move(monster, board);

        int newX = monster.GetCurrentX();
        int newY = monster.GetCurrentY();
        int dist = Math.abs(newX - 2) + Math.abs(newY - 2);

        assertEquals(1, dist);
        assertTrue(board.IsWalkable(newX, newY));
    }

    @Test
    @DisplayName("Pattern 2 - PatrolMovementPattern: Monster moves forward and turns when hitting a wall")
    void PatrolMovementPattern_MovesAlongWalls() {
        LevelOne level = new LevelOne();
        GameBoard board = new GameBoard(level);
        HumanoidMonster monster = new HumanoidMonster(10, 10); // defaults to Patrol

        // Place monster at (7, 1) in LevelOne (row 1 is floor up to x=8, x=9 is door/wall)
        while (monster.GetCurrentX() < 7) monster.MoveRight();
        while (monster.GetCurrentY() < 1) monster.MoveDown();

        monster.GetMovementDirection().SetHeadingDirection(1); // Heading Right

        IMonsterMovementStrategy strategy = new PatrolMovementPattern();

        // Step 1: Moves right to (8, 1)
        strategy.Move(monster, board);
        assertEquals(8, monster.GetCurrentX());
        assertEquals(1, monster.GetCurrentY());

        // Step 2: Hitting wall/door at x=9, turns clockwise (Down) and moves to (8, 2)
        strategy.Move(monster, board);
        assertEquals(8, monster.GetCurrentX());
        assertEquals(2, monster.GetCurrentY());
        assertEquals(2, monster.GetMovementDirection().GetHeadingDirection()); // Heading is now Down
    }

    @Test
    @DisplayName("Pattern 3 - SearchMovementPattern: Monster moves back and forth and steps vertically when hitting walls")
    void SearchMovementPattern_SweepsRoom() {
        LevelOne level = new LevelOne();
        GameBoard board = new GameBoard(level);
        UndeadMonster monster = new UndeadMonster(10, 10); // defaults to Search

        // Place monster at (6, 1) heading Right, vertical direction Down (1)
        while (monster.GetCurrentX() < 6) monster.MoveRight();
        while (monster.GetCurrentY() < 1) monster.MoveDown();

        monster.GetMovementDirection().SetHorizontalDirection(1);
        monster.GetMovementDirection().SetVerticalDirection(1);

        IMonsterMovementStrategy strategy = new SearchMovementPattern();

        // Move Right to (7, 1)
        strategy.Move(monster, board);
        assertEquals(7, monster.GetCurrentX());
        assertEquals(1, monster.GetCurrentY());

        // Move Right to (8, 1)
        strategy.Move(monster, board);
        assertEquals(8, monster.GetCurrentX());
        assertEquals(1, monster.GetCurrentY());

        // At (8, 1), right is blocked -> steps Down to (8, 2) and reverses horizontal direction to Left (-1)
        strategy.Move(monster, board);
        assertEquals(8, monster.GetCurrentX());
        assertEquals(2, monster.GetCurrentY());
        assertEquals(-1, monster.GetMovementDirection().GetHorizontalDirection());

        // Next step moves Left to (7, 2)
        strategy.Move(monster, board);
        assertEquals(7, monster.GetCurrentX());
        assertEquals(2, monster.GetCurrentY());
    }

    @Test
    @DisplayName("MoveMonsters moves all monsters with their respective AI patterns via MovementService")
    void MoveMonsters_MovesAllMonsters() {
        LevelOne level = new LevelOne();
        GameBoard board = new GameBoard(level);

        BaseMonster monster1 = new HumanoidMonster(10, 10); // Patrol
        BaseMonster monster2 = new UndeadMonster(10, 10);   // Search

        while (monster1.GetCurrentX() < 2) monster1.MoveRight();
        while (monster1.GetCurrentY() < 2) monster1.MoveDown();

        while (monster2.GetCurrentX() < 3) monster2.MoveRight();
        while (monster2.GetCurrentY() < 2) monster2.MoveDown();

        ArrayList<BaseMonster> monsters = new ArrayList<>();
        monsters.add(monster1);
        monsters.add(monster2);

        MovementService.MoveMonsters(monsters, board);

        assertTrue(board.IsWalkable(monster1.GetCurrentX(), monster1.GetCurrentY()));
        assertTrue(board.IsWalkable(monster2.GetCurrentX(), monster2.GetCurrentY()));
    }
}

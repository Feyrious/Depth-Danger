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
}

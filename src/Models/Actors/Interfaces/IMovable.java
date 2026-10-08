package Models.Actors.Interfaces;

public interface IMovable {
    int GetCurrentX();
    int GetCurrentY();
    void MoveUp();
    void MoveDown();
    void MoveLeft();
    void MoveRight();
}

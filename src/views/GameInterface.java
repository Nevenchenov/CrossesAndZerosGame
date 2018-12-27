package views;

import beans.Coordinate;
import beans.GameField;

public interface GameInterface {
    void renderGameField(GameField gameField);
    Coordinate getUserStep();
    void showResult(String message);
    boolean surveyDoPlayMore();
}
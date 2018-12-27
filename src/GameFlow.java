import beans.GameField;
import controller.GameController;
import model.GameLogic;
import views.ConsoleGameInterface;
import views.GameInterface;

public class GameFlow {
    public static void main(String[] args) {
        initializeGame(3,3);
    }

    private static void initializeGame(int fieldWidth, int fieldHeight){
        GameField field = new GameField(fieldWidth,fieldHeight);
        GameInterface gameInterface = new ConsoleGameInterface();
        GameLogic gameLogic = new GameLogic(fieldWidth,fieldHeight);
        GameController gameController = new GameController(field, gameInterface, gameLogic);

        gameController.startGame();
    }
}
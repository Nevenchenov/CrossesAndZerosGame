package controller;

import beans.GameField;
import model.GameLogic;
import views.GameInterface;

public class GameController {
    private GameField gameField;
    private GameInterface gameInterface;
    private GameLogic gameLogic;

    public GameController(GameField gameField, GameInterface gameInterface, GameLogic gameLogic) {
        this.gameInterface = gameInterface;
        this.gameLogic = gameLogic;
        this.gameField = gameField;
    }

    public void startGame() {
        boolean doPlayMore = true;
        while (doPlayMore) {
            gameField.restoreGameField();
            gameInterface.renderGameField(gameField);
            char mark;

            for (int i = 0; i < gameField.getWidth() * gameField.getHeight(); i++) {
                mark = i % 2 == 0 ? 'X' : '0';
                gameField.fillCell(gameInterface.getUserStep(), mark);
                gameInterface.renderGameField(gameField);
                if (checkLineCompleteness()) {
                    showGameResult();
                    break;
                }
            }
            if (!checkLineCompleteness()){
                showTieMsg();
            }
            doPlayMore = gameInterface.surveyDoPlayMore();
        }
        showGoodBye();
    }

    private boolean checkLineCompleteness() {
        return gameLogic.findCompletedLines(gameField);
    }

    private void showGameResult() {
        gameInterface.showResult("Hey! " + String.valueOf(gameLogic.getLinedMark()) + " has won!");
    }

    private void showTieMsg() {
        gameInterface.showResult("Oh! Here is a tie. No one has won!");
    }

    private void showGoodBye() {
        gameInterface.showResult("Good-Bye! See You later soon!");
    }
}
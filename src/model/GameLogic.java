package model;

import beans.GameField;

public class GameLogic {
    private final int LINE_LENGTH;

    public GameLogic(int gameFieldWidth, int gameFieldHeight) {
        // TODO: 18-Dec-18 check logic of line length setting
        if (gameFieldWidth < 3 || gameFieldHeight < 3)
            LINE_LENGTH = 0;
        else if (gameFieldWidth <= 5 || gameFieldHeight <= 5)
            LINE_LENGTH = 3;
        else
            LINE_LENGTH = 5;
    }

    public boolean findCompletedLines(GameField gameField) {
        return checkHorizontal(gameField) ||
                checkVertical(gameField) ||
                checkDiagonal(gameField);
    }

    private boolean checkHorizontal(GameField gameField) {
        boolean isLineFound = false;
        for (int i = 0; i < gameField.getHeight(); i++) {
            if (i > 0 && isLineFound)
                break;
            else {
                for (int j = 0; j + LINE_LENGTH <= gameField.getWidth(); j++) {
                    if (j > 0 && isLineFound)
                        break;
                    else {
                        for (int k = 1; k < LINE_LENGTH; k++) {
                            if (gameField.getCellValue(j, i) != '_' &&
                                    gameField.getCellValue(j, i) == gameField.getCellValue(j + k, i)) {
                                isLineFound = true;
                            } else {
                                isLineFound = false;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return isLineFound;
    }

    private boolean checkVertical(GameField gameField) {
        boolean isLineFound = false;
        for (int i = 0; i < gameField.getWidth(); i++) {
            if (i > 0 && isLineFound)
                break;
            else {
                for (int j = 0; j + LINE_LENGTH <= gameField.getHeight(); j++) {
                    if (j > 0 && isLineFound)
                        break;
                    else {
                        for (int k = 1; k < LINE_LENGTH; k++) {
                            if (gameField.getCellValue(i, j) != '_' &&
                                    gameField.getCellValue(i, j) == gameField.getCellValue(i, j + k)) {
                                isLineFound = true;
                            } else {
                                isLineFound = false;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return isLineFound;
    }

    private boolean checkDiagonal(GameField gameField) {
        return checkDescenderDiagonal(gameField) ||
                checkAscenderDiagonal(gameField);
    }

    private boolean checkDescenderDiagonal(GameField gameField) {
        boolean isLineFound = false;
        for (int i = 0; i <= gameField.getHeight() - LINE_LENGTH; i++) {
            if (i > 0 && isLineFound)
                break;
            else {
                for (int j = 0; j <= gameField.getWidth() - LINE_LENGTH; j++) {
                    if (j > 0 && isLineFound)
                        break;
                    else {
                        for (int k = 1; k < LINE_LENGTH; k++) {
                            if (gameField.getCellValue(j, i) != '_' &&
                                    gameField.getCellValue(j, i) == gameField.getCellValue(j + k, i + k)) {
                                isLineFound = true;
                            } else {
                                isLineFound = false;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return isLineFound;
    }

    private boolean checkAscenderDiagonal(GameField gameField) {
        boolean isLineFound = false;
        for (int i = 0; i <= gameField.getHeight() - LINE_LENGTH; i++) {
            if (i > 0 && isLineFound)
                break;
            else {
                for (int j = 0; j <= gameField.getWidth() - LINE_LENGTH; j++) {
                    if (j > 0 && isLineFound)
                        break;
                    else {
                        for (int k = 0; k < LINE_LENGTH - 1; k++) {
                            if (gameField.getCellValue(j + k, i + LINE_LENGTH - 1 - k) != '_' &&
                                    gameField.getCellValue(j + k, i + LINE_LENGTH - 1 - k) == gameField.getCellValue(j + k + 1, i + LINE_LENGTH - k - 1 - 1)) {
                                isLineFound = true;
                            } else {
                                isLineFound = false;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return isLineFound;
    }

    public int getLINE_LENGTH() {
        return LINE_LENGTH;
    }
}
package views;

import beans.Coordinate;
import beans.GameField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleGameInterface implements GameInterface {
    private BufferedReader reader;
    private int gameFieldWidth;
    private int gameFieldHeight;

    public ConsoleGameInterface() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void renderGameField(GameField gameField) {
        gameFieldWidth = gameField.getWidth();
        gameFieldHeight = gameField.getHeight();
        for(int i = 0; i < gameFieldHeight; i++){
            for(int j = 0; j < gameFieldWidth; j++){
                System.out.print(gameField.getCellValue(j,i) + "  ");
            }
            System.out.println();
        }
    }

    @Override
    public Coordinate getUserStep() {
        int x = 0, y = 0;
        System.out.printf("Input horizontal cell number as integer from 1 up to %d and press Enter", gameFieldWidth);
        try {
            x = Integer.parseInt(reader.readLine()) - 1;
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("Input vertical cell number as integer from 1 up to %d and press Enter", gameFieldHeight);
        try {
            x = Integer.parseInt(reader.readLine()) - 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Coordinate(x,y);
    }

    @Override
    public void showResult(String message){
        System.out.println(message);
    }

    @Override
    protected void finalize() throws Throwable {
        reader.close();
    }

    public int getGameFieldWidth() {
        return gameFieldWidth;
    }

    public int getGameFieldHeight() {
        return gameFieldHeight;
    }
}
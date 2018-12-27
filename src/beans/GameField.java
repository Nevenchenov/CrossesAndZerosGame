package beans;

public class GameField {
    private int width;
    private int height;
    private char[][] gameField;

    public GameField(int width, int height) {
        this.width = width;
        this.height = height;

        gameField = new char[width][height];
        fillGameField();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getGameField() {
        return gameField;
    }

    public void fillCell(int x, int y, char value) {
        gameField[x][y] = value;
    }

    public void fillCell(Coordinate coord, char value) {
        gameField[coord.getX()][coord.getY()] = value;
    }

    public char getCellValue(int x, int y) {
        return gameField[x][y];
    }

    public void restoreGameField(){
        fillGameField();
    }

    private void fillGameField() {
        for(int i = 0; i < getHeight(); i++){
            for(int j = 0; j < getWidth(); j++){
                fillCell(j,i, '_');
            }
        }
    }
}
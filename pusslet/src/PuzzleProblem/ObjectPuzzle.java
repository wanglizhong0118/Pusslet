package PuzzleProblem;

/**
 * This is a Puzzle Object.
 *
 * A puzzle object is supposed to contain all the puzzle-pieces(in a string
 * array), the number of the rows and the number of the columns.
 *
 * @author Lizhong Wang
 */
public class ObjectPuzzle {

    public String[] puzzles;
    public int row;
    public int column;

    public ObjectPuzzle(String[] puzzles, int row, int column) {
        this.puzzles = puzzles;
        this.row = row;
        this.column = column;
    }

    public String[] getPuzzles() {
        return puzzles;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setPuzzles(String[] puzzles) {
        this.puzzles = puzzles;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

}

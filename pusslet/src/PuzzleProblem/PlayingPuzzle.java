package PuzzleProblem;

/**
 * This class plays the input puzzle-pieces, studying all permutations of the
 * pieces, creating the puzzle frame/structure.
 *
 *
 * @author Lizhong Wang
 */
public class PlayingPuzzle {

    /**
     * Start playing the input puzzle-pieces
     *
     * @param pz The input puzzle object
     * @return The number of correct solutions
     */
    public static int Initialization(ObjectPuzzle pz) {
        String[] str = pz.getPuzzles();
        int row = pz.getRow();
        int column = pz.getColumn();
        return fullPermutation(str, 0, str.length, row, column);
    }

    static int solutions = 0;

    /**
     * This method gets all possible permutations of the puzzle-pieces by using
     * a recursive method;
     *
     * Each permutation will be send to assemble the complete puzzle in a
     * decided puzzle-frame/structure(row*column);
     *
     * After that, the composistion is send to the verification class to verify
     * whether it is correctly assembled.
     *
     * @param str The puzzle pieces in a string array.
     * @param start The start posisiton of the element permutated recursively.
     * @param len The number of the puzzle pieces.
     * @param row The supposed row size.
     * @param column The supposed column size.
     * @return The number of all the possible correct composition of the puzzle.
     */
    public static int fullPermutation(String[] str, int start, int len, int row, int column) {
        if (start == len - 1) {
            String[][] model = createStructure(str, row, column);
            boolean correctArrangement = Verification.done(model, row, column);
            if (correctArrangement) {
                solutions++;
            }
        } else {
            for (int i = start; i < len; i++) {
                swap(str, start, i);
                fullPermutation(str, start + 1, len, row, column);
                swap(str, start, i);
            }
        }
        return solutions;
    }

    /**
     * A help method that swaps the neighbour elements in a string array.
     *
     * @param str The input string array.
     * @param i The first element.
     * @param j The second element.
     */
    public static void swap(String[] str, int i, int j) {
        String temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    /**
     * Creation of the decided puzzle frame/structure (row*column), and then the
     * puzzle-pieces (in any permutation) are placed one by one in the frame.
     *
     * @param str The puzzle pieces.
     * @param row The decided row size
     * @param col The decided column size.
     * @return The possible composition of the puzzles pieces.
     */
    public static String[][] createStructure(String[] str, int row, int col) {
        String[][] structure = new String[col][row];
        int index = -1;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                index++;
                structure[i][j] = str[index];
            }
        }
        return structure;
    }

}

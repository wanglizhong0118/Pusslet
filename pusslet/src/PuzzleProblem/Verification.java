package PuzzleProblem;

/**
 * This class aims to verify the constructed puzzle from the Class.Structure.
 *
 * Fisrtly, the four side/edge pieces of the frame are going to be checked. If
 * they are not straight,the verification is immediately terminated. After that,
 * the compositions of all the inside pieces are verified to determin whether
 * they are correctly assembled, this check-processing begins with row-check and
 * the performs comlum-check.
 *
 * The optimization of this method/class is limited to different assumptions.
 *
 * @author Lizhong Wang
 *
 */
public class Verification {

    public static boolean done(String[][] puzzle, int row, int col) {

        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;
        boolean frame = false;

        int inRow = 0;
        boolean inRowBool = false;
        int inCol = 0;
        boolean inColBool = false;

        boolean finalBool = false;

        for (int i = 0; i < row; i++) {
            if (puzzle[0][i].charAt(0) == 'R') {
                up++;
            }
            if (puzzle[col - 1][i].charAt(2) == 'R') {
                down++;
            }
        }
        for (int i = 0; i < col; i++) {
            if (puzzle[i][0].charAt(3) == 'R') {
                left++;
            }
            if (puzzle[i][row - 1].charAt(1) == 'R') {
                right++;
            }
        }

        if (up == down && up == row && left == right && left == col) {
            frame = true;
        }

        if (frame) {
            for (int i = 0; i < col; i++) {
                for (int j = 0; j < row - 1; j++) {
                    if (puzzle[i][j].charAt(1) == 'I' && puzzle[i][j + 1].charAt(3) == 'U') {
                        inRow++;
                    }
                    if (puzzle[i][j].charAt(1) == 'U' && puzzle[i][j + 1].charAt(3) == 'I') {
                        inRow++;
                    }
                    if (puzzle[i][j].charAt(1) == 'R' && puzzle[i][j + 1].charAt(3) == 'R') {
                        inRow++;
                    }
                }
            }
            if (inRow == col * (row - 1)) {
                inRowBool = true;
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col - 1; j++) {
                    if (puzzle[j][i].charAt(2) == 'I' && puzzle[j + 1][i].charAt(0) == 'U') {
                        inCol++;
                    }
                    if (puzzle[j][i].charAt(2) == 'U' && puzzle[j + 1][i].charAt(0) == 'I') {
                        inCol++;
                    }
                    if (puzzle[j][i].charAt(2) == 'R' && puzzle[j + 1][i].charAt(0) == 'R') {
                        inCol++;
                    }
                }
            }
            if (inCol == row * (col - 1)) {
                inColBool = true;
            }
        }

        if (inRowBool && inColBool) {
            finalBool = true;
        }

        return finalBool;
    }
}

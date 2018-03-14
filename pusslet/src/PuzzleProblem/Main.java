package PuzzleProblem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * This program is based on an readable text file, All puzzle pieces are
 * included in a text file, A puzzle piece must have four sides which are
 * defined as different names(R,I,U), R represents a straight side(used for
 * making up the frame), I represents a bulge while U for recess,No bits in this
 * program can be twisted or turned, The program calculates the number of all
 * possible solutions that assemble correctly the puzzle.
 *
 * Limitation: This program is only able to work with the neighbour pieces that
 * are connected by I and U. The R-R connection is unfortunately not allowed.
 *
 * @author Lizhong Wang
 */
public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the file address：");
        Scanner sc = new Scanner(System.in);
        String fileAddress = sc.nextLine();

        //String fileAddress = "E://Fyra.txtE://Fyra.txt";
        ArrayList<String> templist = new ArrayList<>();
        int column = 0;
        int row = 0;

        try (final FileInputStream fs = new FileInputStream(fileAddress)) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(fs));
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {

                templist.add(line);
                String firstLetter = String.valueOf(line.charAt(0));
                String secondLetter = String.valueOf(line.charAt(1));

                if ("R".equals(firstLetter)) {
                    row++;
                }
                if ("R".equals(secondLetter)) {
                    column++;
                }
            }
        }
        String[] puzzleArray = templist.toArray(new String[templist.size()]);

        //System.out.println("File Reading Completed");
        ObjectPuzzle newPuzzle = new ObjectPuzzle(puzzleArray, row, column);
        //System.out.println("Puzzle Object Construction Completed");

        //System.out.println("The number of row is: " + newPuzzle.getRow());
        //System.out.println("The number of column is: " + newPuzzle.getColumn());
        //System.out.println("Starting Calculation Possible Solutions");
        int solutions = PlayingPuzzle.Initialization(newPuzzle);

        System.out.println("There are " + solutions + " solutions");

    }

}

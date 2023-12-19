import java.io.*;
import java.util.*;

/**
 * The Lab1ZastavnyiKI305 class implements an example program for laboratory work 1.
 *
 * @author Roman Zastavnyi
 */
public class Lab1ZastavnyiKI305 {

    public static void main(String[] args) throws FileNotFoundException {
        int nRows; // Variable to store the size of a square matrix
        char[][] arr; // Two-dimensional array to represent the matrix
        String filler; // Filling character
        Scanner in = new Scanner(System.in); // Scanner object for input from the console
        File dataFile = new File("MyFile.txt"); // File for writing results
        PrintWriter fout = new PrintWriter(dataFile); // PrintWriter object for writing to a file

        // Entering the size of a square matrix
        System.out.print("Enter the size of the square matrix: ");
        nRows = in.nextInt();
        in.nextLine(); // Clearing the input buffer

        arr = new char[nRows][]; // Initializing the matrix

        for (int i = 0; i < nRows; i++) {
            arr[i] = new char[nRows - i - 1]; // Initializing each row of the matrix
        }

        // Entering the filler character
        System.out.print("\nEnter the filler character: ");
        filler = in.nextLine();

        exit:
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nRows - i - 1; j++) {
                if (filler.length() == 1) {
                    arr[i][j] = (char) filler.codePointAt(0);
                    System.out.print(arr[i][j] + " ");
                    fout.print(arr[i][j] + " ");
                } else if (filler.length() == 0) {
                    System.out.print("\nFiller character not entered");
                    break exit;
                } else {
                    System.out.print("\nToo many filler characters entered");
                    break exit;
                }
            }

            System.out.print("\n");
            fout.print("\n");
        }

        fout.flush(); // Force flushing the file write buffer
        fout.close(); // Closing the PrintWriter object
    }
}

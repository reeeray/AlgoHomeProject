package coursera.projects_part2.burrows;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 19.07.2020
 **/
public class MoveToFront {
    /*
     * Apply move-to-front encoding, reading from
     * standard input and writing to standard output
     */
    public static void encode() {
        // Initialize ascii ordered character array
        char[] letters = new char[256];
        for (int i = 0; i < 256; i++) {
            letters[i] = (char) i;
        }

        // Process input
        while (!BinaryStdIn.isEmpty()) {
            // Read character
            char c = BinaryStdIn.readChar();

            // Find index of current character
            int index = -1;
            for (int i = 0; letters[i] != c; i++) {
                index = i;
            }
            index++;

            // Output encoded character
            BinaryStdOut.write((char) index);

            // Swap recently encoded character to front of array
            for (int i = index; i - 1 >= 0; i--) {
                char temp = letters[i - 1];
                letters[i - 1] = letters[i];
                letters[i] = temp;
            }
        }
        BinaryStdOut.close();
    }

    /*
     * apply move-to-front decoding, reading from standard input
     * and writing to standard output
     */
    public static void decode() {
        // Initialize ascii ordered character array
        char[] letters = new char[256];
        for (int i = 0; i < 256; i++) {
            letters[i] = (char) i;
        }

        // Process input
        while (!BinaryStdIn.isEmpty()) {
            // Read integer
            int index = (int) BinaryStdIn.readChar();

            // Output decoded character
            BinaryStdOut.write(letters[index]);

            // Swap recently decoded character to front of array
            for (int i = index; i - 1 >= 0; i--) {
                char temp = letters[i - 1];
                letters[i - 1] = letters[i];
                letters[i] = temp;
            }
        }
        BinaryStdOut.close();

    }

    public static void main(String[] args) {
        if (args[0].equals("-")) {
            encode();
        } else if (args[0].equals("+")) {
            decode();
        } else {
            throw new IllegalArgumentException();
        }
    }
}

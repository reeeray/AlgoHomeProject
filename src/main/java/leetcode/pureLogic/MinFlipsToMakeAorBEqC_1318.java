package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.06.2023
 **/
public class MinFlipsToMakeAorBEqC_1318 {

    public static void main(String[] args) {
        minFlips(2, 6, 5);
    }


    //check how works bit operands
    public static int minFlips(int a, int b, int c) {
        int flips = 0;
        while (a > 0 || b > 0 || c > 0) {
            int bitA = a & 1;
            int bitB = b & 1;
            int bitC = c & 1;

            if (bitC == 0) {
                flips += (bitA + bitB);
            } else {
                if (bitA == 0 && bitB == 0) {
                    flips += 1;
                }
            }

            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return flips;
    }
}

package leetcode.binaryStuff;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 30.11.2023
 **/
public class MinOneBitOperationsToMakeIntegersZero_1611 {

    public static void main(String[] args) {

    }

    //Math : number of bit operations to make 2^K zero is 2^(k+1) - 1. In binary terminology 2^(k+1) = 1 << (k-1)
    public static int minimumOneBitOperations(final int n) {
        if(n == 0) {
            return 0;
        }
        int highestBit = 0;
        int curr = 1;
        while(2*curr <= n) {
            curr*=2;
            highestBit++;
        }
        return (1 << (highestBit + 1)) - 1 -minimumOneBitOperations(n ^ curr);
    }
}

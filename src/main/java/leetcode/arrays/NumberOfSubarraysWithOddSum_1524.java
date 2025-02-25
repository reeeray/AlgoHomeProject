package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 25.02.2025
 **/
public class NumberOfSubarraysWithOddSum_1524 {

    private final static int MOD = (int)1e9 + 7;
    public static void main(String[] args) {
        System.out.println(numbOfSubArrays(new int[] {1, 2, 3, 4, 5, 6, 7}));
    }

    //TLE : Time O(n^2) and Space O(1)
    public static int numbOfSubArraysBruteForce(final int[] arr) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            int oddCounter = 0;
            for(int j = i; j < arr.length; j ++) {
                if(arr[j] == 0) {
                    oddCounter++;
                }
                if(oddCounter % 2 != 0) {
                    count++;
                }
            }
        }
        return count % MOD;
    }

    //Dynamic programming Time O(n) and Space O(n)
    public static int numbOfSubArraysDP(final int[] arr) {
        final int[] dpEven = new int[arr.length];
        final int[] dpOdd = new int[arr.length];
        if(arr[arr.length - 1] % 2 == 1) {
            dpOdd[arr.length - 1] = 1;
        } else {
            dpEven[arr.length - 1] = 1;
        }

        for(int i = arr.length - 2; i >= 0; i--) {
            if(arr[i] % 2 == 0) {
                dpEven[i] = (1 + dpEven[i + 1]) % MOD;
                dpOdd[i] = dpOdd[i + 1];
            } else {
                dpOdd[i] = (1 + dpEven[i + 1]) % MOD;
                dpEven[i] = dpOdd[i + 1];
            }
        }
        int count = 0;
        for(final int odd : dpOdd) {
            count = (count + odd) % MOD;
        }
        return count;
    }

    public static int numbOfSubArrays(final int[] arr) {
        int count = 0;
        int prefixSum = 0;
        int oddCounter = 0, evenCounter = 1;
        for(int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if(prefixSum % 2 == 0) {
                count += oddCounter;
                evenCounter++;
            } else {
                count += evenCounter;
                oddCounter++;
            }
            count %= MOD;
        }
        return count;
    }
}

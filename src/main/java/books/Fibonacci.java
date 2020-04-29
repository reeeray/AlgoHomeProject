package books;

/**
 * Created by Shein G.A. at 26.04.20
 **/
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(getFastFib(100));
    }

    //slow O(2^n)
    public static long getSlowFib(final int n) {
        if(n <= 1) {
            return n;
        }
        return getSlowFib(n-2) + getSlowFib(n-1);
    }

    //using memoization - save result of previous execution of function to prevent repeating calculations
    public static long getMemFib(final int n, final long[] storage) {
        if(storage[n] != -1) {
            return storage[n];
        }

        if(n <= 1) {
            storage[n] = n;
            return n;
        }

        long res = getMemFib(n - 2, storage) + getMemFib(n - 1, storage);
        storage[n] = res;
        return res;
    }
    //uses additional memory O(n + n) =>  O(n)
    public static long getFastFib(final int n) {
        final long[] storage = new long[n + 1];

        storage[0] = 0;
        storage[1] = 1;

        for(int i=2; i <= n; i++) {
            storage[i] = storage[i-1] + storage[i-2];
        }

        return storage[n];
    }
}

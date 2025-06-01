package leetcode.combinatorics;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.06.2025
 **/
public class DistributeCandiesAmongChildrenII_2929 {

    public static void main(String[] args) {

    }

    //Time O(min(limit, n)) Space O(1)
    public static long distributeCandies(final int n, final int limit) {
        long ans = 0;
        for(int i = 0; i <= Math.min(n, limit); i++) {
            if(n - i > 2 * limit) {
                continue;
            }
            ans += Math.min(n - i, limit) - Math.max(0, n - i - limit) + 1;
        }
        return ans;
    }

    //C
    //n+2
    //2
    //​
    // −3×C
    //n−(limit+1)+2
    //2
    //​
    // +3×C
    //n−2×(limit+1)+2
    //2
    //​
    // −C
    //n−3×(limit+1)+2
    //2
    //​
    //cominatorics Time O(1) and Space O(1)
    public static long distributeCandiesCombinatorics(final int n, final int limit) {
        return (combinatoricFunction(n + 2) -
                        3 * combinatoricFunction(n - limit + 1) +
                        3 * combinatoricFunction(n - (limit + 1) * 2 + 2) -
                combinatoricFunction(n - 3 * (limit + 1) + 2)
        );
    }

    public static long combinatoricFunction(final int x) {
        if (x < 0) {
            return 0;
        }
        return ((long) x * (x - 1)) / 2;
    }
}
